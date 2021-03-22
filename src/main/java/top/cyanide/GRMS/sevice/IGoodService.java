package top.cyanide.GRMS.sevice;

import java.util.List;
import top.cyanide.GRMS.pojo.Product;

/**
 * @author Bai
 */
public interface IGoodService {
    List<Product> findAllGoods();

    List<Product> findAllGoods(String productName);

    void add(Product good);

    void buy(Integer userId, Integer productId, String productName);
}
