package top.cyanide.GRMS.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cyanide.GRMS.dao.OrderMapper;
import top.cyanide.GRMS.pojo.Order;
import top.cyanide.GRMS.pojo.OrderExample;
import top.cyanide.GRMS.sevice.IOrderService;

import java.util.List;

/**
 * @author Bai
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrders() {
        return this.orderMapper.selectByExample(new OrderExample());
    }
}
