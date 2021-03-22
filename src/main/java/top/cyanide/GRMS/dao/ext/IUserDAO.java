package top.cyanide.GRMS.dao.ext;

import org.apache.ibatis.annotations.Param;
import top.cyanide.GRMS.pojo.User;

import java.util.List;

/**
 * @author Bai
 */
public interface IUserDAO {
    User selectByIdUser(Integer id);

    List<User> findAllUsers(@Param(value = "userId") String name);
}
