package top.cyanide.GRMS.sevice.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cyanide.GRMS.dao.GoodMapper;
import top.cyanide.GRMS.dao.OrderMapper;
import top.cyanide.GRMS.dao.ext.IGoodDAO;
import top.cyanide.GRMS.pojo.Good;
import top.cyanide.GRMS.pojo.Order;
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
    private GoodMapper goodMapper;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Good> findAllGoods() {
        return null;
    }

    @Override
    public List<Good> findAllGoods(String name) {
        return this.goodDAO.findAllGoods(name);
    }

    @Override
    public void add(Good good) {
        this.goodMapper.insert(good);
    }

    @Override
    public void buy(Integer uid, Integer gid) {
        Order order = new Order();
        order.setUid(uid);
        order.setGid(gid);
        this.orderMapper.insert(order);
    }
}
