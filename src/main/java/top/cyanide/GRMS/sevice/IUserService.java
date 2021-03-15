package top.cyanide.GRMS.sevice;

import top.cyanide.GRMS.pojo.User;

import java.util.List;

/**
 * @author Bai
 */
public interface IUserService {
    void add(User user);

    User find(Integer id);

    User delete(Integer id);

    User selectById(Integer id);

    List<User> findAllUsers();

    List<User> findAllUsers(String name);

    User findUserByToken(String token);
}
