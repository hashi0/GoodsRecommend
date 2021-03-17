package top.cyanide.GRMS.controller;

import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cyanide.GRMS.common.constant.ErrorCode;
import top.cyanide.GRMS.model.response.BasicResponse;
import top.cyanide.GRMS.pojo.User;
import top.cyanide.GRMS.sevice.IUserService;
import top.cyanide.GRMS.utils.JwtUtils;
import top.cyanide.GRMS.utils.MapUtils;
import top.cyanide.GRMS.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bai
 */
@Api("用户相关接口")
@RestController
@RequestMapping(value = "/grms/user", produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @ApiOperation(value = "添加用户接口", consumes = "application/json;charset=UTF-8")
    @PostMapping(value = "add")
    public BasicResponse add(@RequestBody User user) {
        this.userService.add(user);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("添加成功");
        response.setData(user);
        return response;
    }

    @ApiOperation("查询用户接口")
    @GetMapping(value = "find/{id}")
    public BasicResponse find(@PathVariable String id) {
        User user = this.userService.find(Integer.parseInt(id));
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("查询成功");
        response.setData(user);
        return response;
    }

    @ApiOperation("删除用户接口")
    @DeleteMapping(value = "delete/{id}")
    public BasicResponse delete(@PathVariable String id) {
        try {
            int userId = Integer.parseInt(id);
            if (this.userService.find(userId) == null) {
                BasicResponse response = new BasicResponse();
                response.setErrorCode(ErrorCode.NONE_EXIST);
                response.setErrorMessage("查无此用户，请检查用户ID是否正确！");
                return response;
            } else {
                User user = this.userService.delete(userId);
                BasicResponse response = new BasicResponse();
                response.setErrorCode(ErrorCode.SUCCESS);
                response.setErrorMessage("删除成功！");
                response.setData(user);
                return response;
            }
        } catch (NumberFormatException e) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("非法用户ID，请检查！");
            return response;
        }
    }

    @ApiOperation("用户登录接口")
    @PostMapping(value = "login")
    public BasicResponse login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        if (username == null || password == null) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("用户名或密码错误！");
            return response;
        }

        User user = this.userService.selectById(Integer.parseInt(username));
        if (user == null) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.NONE_EXIST);
            response.setErrorMessage("查无此用户！");
            return response;
        }
        if (!user.getPasswd().equals(password)) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("密码错误！");
            return response;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("name", user.getName());
        data.put("age", user.getAge());
        data.put("gender", user.getGender());
        String token = this.jwtUtils.createJwt(String.valueOf(user.getId()), user.getPasswd(), data);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("登录成功！");
        response.setData(MapUtils.newMap().add("token", token).get());
        return response;
    }

    @ApiOperation("获取用户信息接口")
    @PostMapping(value = "profile")
    public BasicResponse profile(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("用户身份认证失败！");
            return response;
        }
        Claims claims = jwtUtils.parseJwt(authorization.split(" ")[1]);
        String id = claims.getId();
        User user = this.userService.find(Integer.parseInt(id));
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取用户信息成功！");
        response.setData(user);
        return response;
    }

    @ApiOperation("获取用户信息接口")
    @GetMapping(value = "all")
    public BasicResponse findAllUsers(
            @RequestParam(value = "query") String name,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        if (page < 1 || pageSize < 1) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("分页参数传递错误！");
            return response;
        }
        Map<String, Object> map = new HashMap<>();
        List<User> allUsers = this.userService.findAllUsers(name);
        map.put("total", allUsers.size());
        allUsers = allUsers.subList(pageSize > allUsers.size() ? 0 : (page - 1) * pageSize, Math.min((page) * pageSize, allUsers.size()));
        map.put("users", allUsers);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取用户信息成功！");
        response.setData(map);
        return response;
    }
}
