package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.service.AuthService;
import cn.hist.greenHouse.util.JwtUtil;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {
    public User user;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        System.out.println("authenticationToken："+authenticationToken);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        System.out.println("authentication："+authentication);
        if(Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        HashMap<String,String> authToken = new HashMap<>();
        authToken.put("auth",jwt);
          this.user = loginUser.getUser();
//        session.setAttribute("userData",loginUser.getUser());
        System.out.println("测试："+loginUser.getUser());
        return new ResponseResult(200,"登录成功",authToken);
    }
}
