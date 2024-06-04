package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.mapper.UserMapper;
import cn.hist.greenHouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUsreByName(username);
        if(Objects.isNull(user)){
//            如果没有查询到用户则抛出异常
            throw new RuntimeException("用户名或者密码错误！");
        }
        return new LoginUser(user);
    }
}
