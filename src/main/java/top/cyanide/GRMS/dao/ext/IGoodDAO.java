package top.cyanide.GRMS.dao.ext;

import org.apache.ibatis.annotations.Param;
import top.cyanide.GRMS.pojo.Good;

import java.util.List;

/**
 * @author Bai
 */
public interface IGoodDAO {
    List<Good> findAllGoods(@Param(value = "name") String name);
}
