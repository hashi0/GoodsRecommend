package top.cyanide.GRMS.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cyanide.GRMS.common.constant.ErrorCode;
import top.cyanide.GRMS.model.response.BasicResponse;
import top.cyanide.GRMS.pojo.Good;
import top.cyanide.GRMS.pojo.User;
import top.cyanide.GRMS.sevice.IGoodService;
import top.cyanide.GRMS.sevice.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("商品相关接口")
@RestController
@RequestMapping(value = "/grms/good", produces = "application/json;charset=UTF-8")
public class GoodController {
    @Autowired
    private IGoodService goodService;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加商品接口", consumes = "application/json;charset=UTF-8")
    @PostMapping(value = "add")
    public BasicResponse add(@RequestBody Good good) {
        this.goodService.add(good);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("商品添加成功");
        response.setData(good);
        return response;
    }

    @ApiOperation("获取商品信息接口")
    @GetMapping(value = "all")
    public BasicResponse findAllGoods(
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
        List<Good> allGoods = this.goodService.findAllGoods(name);
        map.put("total", allGoods.size());
        allGoods = allGoods.subList(pageSize > allGoods.size() ? 0 : (page - 1) * pageSize, Math.min((page) * pageSize, allGoods.size()));
        map.put("goods", allGoods);
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取商品信息成功！");
        response.setData(map);
        return response;
    }

    @ApiOperation(value = "购买商品接口", consumes = "application/json;charset=UTF-8")
    @PostMapping(value = "buy")
    public BasicResponse buy(
            HttpServletRequest request,
            @RequestBody Good good
    ) {
        String token = request.getHeader("Authorization");
        User user = this.userService.findUserByToken(token);
        this.goodService.buy(user.getId(), good.getId());
        BasicResponse response = new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("商品购买成功");
        return response;
    }
}
