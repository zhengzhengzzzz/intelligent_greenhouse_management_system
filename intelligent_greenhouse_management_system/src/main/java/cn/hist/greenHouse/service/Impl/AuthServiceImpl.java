package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.service.AuthService;
import cn.hist.greenHouse.service.UserService;
import cn.hist.greenHouse.util.JwtUtil;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {
//    public LoginUser user;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Override
    public ResponseResult login(User user){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        HashMap<String,Object> authToken = new HashMap<>();
//        前端要求必须返回用户的信息
        authToken.put("user",loginUser.getUser());
        authToken.put("token",jwt);
        authToken.put("role",loginUser.getUser().getRole().toString());
        return new ResponseResult(200,"登录成功",authToken);
    }
    @Override
    public ResponseResult logout(HttpServletRequest request){
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request,null,null);
        return new ResponseResult(200,"注销成功");
    }

    @Override
    public ResponseResult register(User user){
        User existingUser = userService.getUserByUsername(user.getUsername());
        if(existingUser != null){
            return new ResponseResult(400,"用户名已经存在");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(String.valueOf('0'));
        userService.saveUser(user);
        return new ResponseResult(200,"注册成功");
    }
}
