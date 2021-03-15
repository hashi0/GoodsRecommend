package top.cyanide.GRMS.controller;

import com.briup.bigdata.pre.grms.web.bean.Order;
import com.briup.bigdata.pre.grms.web.common.constant.ErrorCode;
import com.briup.bigdata.pre.grms.web.model.response.BasicResponse;
import com.briup.bigdata.pre.grms.web.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("订单相关接口")
@RestController
@RequestMapping(value="/grms/order", produces="application/json;charset=UTF-8")
public class OrderController{
    @Autowired
    private IOrderService orderService;

    @ApiOperation("获取订单信息接口")
    @GetMapping(value="all")
    public BasicResponse findAllOrders(
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
        List<Order> allOrders=this.orderService.findAllOrders();
        map.put("total",allOrders.size());
        allOrders=allOrders.subList(pageSize>allOrders.size()?0:(page-1)*pageSize,Math.min((page)*pageSize,allOrders.size()));
        map.put("orders",allOrders);
        BasicResponse response=new BasicResponse();
        response.setErrorCode(ErrorCode.SUCCESS);
        response.setErrorMessage("获取订单信息成功！");
        response.setData(map);
        return response;
    }
}