package top.cyanide.GRMS.controller;

import com.briup.bigdata.pre.grms.web.bean.Result;
import com.briup.bigdata.pre.grms.web.bean.User;
import com.briup.bigdata.pre.grms.web.common.constant.ErrorCode;
import com.briup.bigdata.pre.grms.web.model.response.BasicResponse;
import com.briup.bigdata.pre.grms.web.service.IResultService;
import com.briup.bigdata.pre.grms.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("推荐结果相关接口")
@RestController
@RequestMapping(value="/grms/result", produces="application/json;charset=UTF-8")
public class ResultController{
    @Autowired
    private IResultService resultService;
    @Autowired
    private IUserService userService;

    @ApiOperation("获取订单信息接口")
    @GetMapping(value="all")
    public BasicResponse findAllResults(
        @RequestParam(value="uid",required=false) Integer uid,
        @RequestParam(value="page") Integer page,
        @RequestParam(value="pageSize") Integer pageSize
    ){
        if(page<1||pageSize<1){
            BasicResponse response=new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("分页参数传递错误！");
            return response;
        }
        Map<String,Object> map=new HashMap<>();
        List<Result> allResults=this.resultService.findAllResults(uid);
        map.put("total",allResults.size());
        allResults=allResults.subList(pageSize>allResults.size()?0:(page-1)*pageSize,Math.min((page)*pageSize,allResults.size()));
        map.put("results",allResults);
        BasicResponse response=new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取推荐信息成功！");
        response.setData(map);
        return response;
    }

    @ApiOperation("获取订单信息接口")
    @GetMapping(value="my")
    public BasicResponse findMyResults(
        HttpServletRequest request,
        @RequestParam(value="page") Integer page,
        @RequestParam(value="pageSize") Integer pageSize
    ){
        if(page<1||pageSize<1){
            BasicResponse response=new BasicResponse();
            response.setErrorCode(ErrorCode.ERRORR);
            response.setErrorMessage("分页参数传递错误！");
            return response;
        }
        String token=request.getHeader("Authorization");
        User user=this.userService.findUserByToken(token);
        Map<String,Object> map=new HashMap<>();
        List<Result> allResults=this.resultService.findAllResults(user.getId());
        map.put("total",allResults.size());
        allResults=allResults.subList(pageSize>allResults.size()?0:(page-1)*pageSize,Math.min((page)*pageSize,allResults.size()));
        map.put("results",allResults);
        BasicResponse response=new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取推荐信息成功！");
        response.setData(map);
        return response;
    }
}
