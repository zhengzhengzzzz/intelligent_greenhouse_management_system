package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.util.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface AuthService {
    ResponseResult login(User user);
    ResponseResult logout(HttpServletRequest request);
    ResponseResult register(User user);
}
