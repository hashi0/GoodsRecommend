package top.cyanide.GRMS.sevice.impl;

import io.jsonwebtoken.Claims;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cyanide.GRMS.dao.UserMapper;
import top.cyanide.GRMS.dao.ext.IUserDAO;
import top.cyanide.GRMS.pojo.User;
import top.cyanide.GRMS.pojo.UserExample;
import top.cyanide.GRMS.sevice.IUserService;
import top.cyanide.GRMS.utils.JwtUtils;

import java.util.List;

/**
 * @author Bai
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private IUserDAO userDAO;

    @Override
    public void add(User user) {
        this.userMapper.insert(user);
    }

    @Override
    public User find(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User delete(Integer id) {
        User user = this.find(id);
        this.userMapper.deleteByPrimaryKey(id);
        return user;
    }

    @Override
    public User selectById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAllUsers() {
        UserExample userExample = new UserExample();
        return this.userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findAllUsers(String name) {
        return this.userDAO.findAllUsers(name);
    }

    @Override
    public User findUserByToken(String token) {
        Claims claims = jwtUtils.parseJwt(token);
        String id = claims.getId();
        return this.find(Integer.parseInt(id));
    }
}
