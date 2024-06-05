package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.User;

import java.util.List;

public interface UserService {
    void deleteUser(Integer id);
    void updateUser(User user);
    List<User> getUsers(Integer pageNum,Integer pageSize);
    Integer getUserCount();
}
