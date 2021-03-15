package top.cyanide.GRMS.sevice;

import top.cyanide.GRMS.pojo.Good;

import java.util.List;

/**
 * @author Bai
 */
public interface IGoodService {
    List<Good> findAllGoods();

    List<Good> findAllGoods(String name);

    void add(Good good);

    void buy(Integer uid, Integer gid);
}
