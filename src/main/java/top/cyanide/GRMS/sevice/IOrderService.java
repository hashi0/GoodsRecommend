package top.cyanide.GRMS.sevice;

import top.cyanide.GRMS.pojo.Order;

import java.util.List;

/**
 * @author Bai
 */
public interface IOrderService {
    List<Order> findAllOrders();
}
