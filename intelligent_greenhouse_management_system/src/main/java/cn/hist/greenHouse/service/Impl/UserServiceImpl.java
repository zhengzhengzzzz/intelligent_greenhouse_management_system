package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.mapper.UserMapper;
import cn.hist.greenHouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void deleteUser(Integer id){
        userMapper.deleteUser(id);
    }
    @Override
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
    @Override
    public List<User> getUsers(Integer pageNum,Integer pageSize){
        if(pageNum == 1){
            pageNum = 0;
        }
        return userMapper.getUsers(pageNum,pageSize);
    }
    @Override
    public Integer getUserCount(){
        return userMapper.getUsersCount();
    }
}
