package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.service.AuthService;
import cn.hist.greenHouse.service.Impl.AuthServiceImpl;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user, HttpSession session){
        System.out.println("user:"+user);
        if(Objects.isNull(user) || Objects.isNull(user.getUsername())|| Objects.isNull(user.getPassword())){
            return new ResponseResult(300,"用户名密码不能为空");
        }
        return authService.login(user);
    }
//    注销
    @RequestMapping("/logout")
    @PreAuthorize("hasAnyRole('1','0')")
    public ResponseResult logout(HttpServletRequest request){
        return authService.logout(request);
    }
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        if(user == null || user.getUsername() == null || user.getPassword() == null){
            return new ResponseResult(400,"用户名和密码不能为空");
        }
        return authService.register(user);
    }
}
