package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails loadUserByUsername(String username);
    User getUserByUsername(String username);
    void deleteUser(Integer id);
    void updateUser(User user);
    List<User> getUsers(Integer pageNum,Integer pageSize);
    Integer getUserCount();
    void saveUser(User user);
}
