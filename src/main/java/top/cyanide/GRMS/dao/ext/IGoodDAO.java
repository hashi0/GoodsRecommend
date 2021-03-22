package top.cyanide.GRMS.dao.ext;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import top.cyanide.GRMS.pojo.Product;

/**
 * @author Bai
 */
public interface IGoodDAO {
    List<Product> findAllGoods(@Param(value = "productName") String name);
}
