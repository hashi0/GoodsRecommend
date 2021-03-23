package top.cyanide.GRMS.sevice.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import top.cyanide.GRMS.dao.OrderMapper;
import top.cyanide.GRMS.dao.ProductMapper;
import top.cyanide.GRMS.dao.ext.IGoodDAO;
import top.cyanide.GRMS.pojo.Order;
import top.cyanide.GRMS.pojo.Product;
import top.cyanide.GRMS.sevice.IGoodService;

import java.util.List;

/**
 * @author Bai
 */
@Service
public class GoodServiceImpl implements IGoodService {
    @Resource
    private IGoodDAO goodDAO;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Product> findAllGoods() {
        return null;
    }

    @Override
    public List<Product> findAllGoods(String productName) {
        return this.goodDAO.findAllGoods(productName);
    }

    @Override
    public void add(Product good) {
        this.productMapper.insert(good);
    }

    @Override
    public void buy(Integer userId, Integer productId, String productName) {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderId(-userId); // 先把新添加的订单号都置为-userId吧
        order.setProductId(productId);
        order.setProductName(productName);
        this.orderMapper.insert(order);
    }
}
