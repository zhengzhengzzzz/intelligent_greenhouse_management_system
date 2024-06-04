package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.util.ResponseResult;

import javax.servlet.http.HttpSession;

public interface AuthService {
    ResponseResult login(User user);
}
