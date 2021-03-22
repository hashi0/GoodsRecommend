package top.cyanide.GRMS.dao.ext;


import org.apache.ibatis.annotations.Param;
import top.cyanide.GRMS.pojo.Result;

import java.util.List;

/**
 * @author Bai
 */
public interface IResultDAO {
    List<Result> findAllResults(@Param(value = "userId") Integer uid);
}
