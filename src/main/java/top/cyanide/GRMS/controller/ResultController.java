package top.cyanide.GRMS.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.cyanide.GRMS.common.constant.ErrorCode;
import top.cyanide.GRMS.model.response.BasicResponse;
import top.cyanide.GRMS.pojo.Result;
import top.cyanide.GRMS.pojo.User;
import top.cyanide.GRMS.sevice.IResultService;
import top.cyanide.GRMS.sevice.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bai
 */
@Api("推荐结果相关接口")
@RestController
@RequestMapping(value = "/grms/result", produces = "application/json;charset=UTF-8")
public class ResultController {
    @Autowired
    private IResultService resultService;
    @Autowired
    private IUserService userService;

    @ApiOperation("获取订单信息接口")
    @GetMapping(value = "all")
    public BasicResponse findAllResults(
        @RequestParam(value = "uid", required = false) Integer uid,
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
        List<Result> allResults = this.resultService.findAllResults(uid);
        map.put("total", allResults.size());
        allResults = allResults.subList(pageSize > allResults.size() ? 0 : (page - 1) * pageSize,
            Math.min((page) * pageSize, allResults.size()));
        map.put("results", allResults);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取推荐信息成功！");
        response.setData(map);
        return response;
    }

    @ApiOperation("获取订单信息接口")
    @GetMapping(value = "my")
    public BasicResponse findMyResults(
        HttpServletRequest request,
        @RequestParam(value = "page") Integer page,
        @RequestParam(value = "pageSize") Integer pageSize
    ) {
        if (page < 1 || pageSize < 1) {
            BasicResponse response = new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("分页参数传递错误！");
            return response;
        }
        String token = request.getHeader("Authorization");
        User user = this.userService.findUserByToken(token);
        Map<String, Object> map = new HashMap<>();
        List<Result> allResults = this.resultService.findAllResults(user.getId());
        map.put("total", allResults.size());
        allResults = allResults.subList(pageSize > allResults.size() ? 0 : (page - 1) * pageSize,
            Math.min((page) * pageSize, allResults.size()));
        map.put("results", allResults);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取推荐信息成功！");
        response.setData(map);
        return response;
    }
}
