//package cn.hist.greenHouse.service.Impl;
//
//import cn.hist.greenHouse.entity.User;
//import cn.hist.greenHouse.service.AuthService;
//import cn.hist.greenHouse.util.JwtUtil;
//import cn.hist.greenHouse.util.ResponseResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class AuthServiceImpl implements AuthService {
////    public LoginUser user;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
////    @Transactional
//    public ResponseResult login(User user){
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
//        System.out.println("authenticationToken："+authenticationToken);
//        Authentication authentication = authenticationManager.authenticate(authenticationToken);
//        System.out.println("authentication："+authentication);
//        if(Objects.isNull(authentication)){
//            throw new RuntimeException("登录失败");
//        }
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        String userId = loginUser.getUser().getId().toString();
////        String role = user.getRole();
////        // 创建权限列表
////        List<GrantedAuthority> authorities = new ArrayList<>();
////        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));  // 根据实际角色创建权限对象
//        String jwt = JwtUtil.createJWT(userId);
//        HashMap<String,String> authToken = new HashMap<>();
//        authToken.put("token",jwt);
////          this.user = loginUser;
////        session.setAttribute("userData",loginUser.getUser());
////        System.out.println("测试："+loginUser.getUser());
//        return new ResponseResult(200,"登录成功",authToken);
//    }
//    @Override
//    public ResponseResult logout(){
////        获取 SecurityContextHolder 中的用户 id
////        UsernamePasswordAuthenticationToken authenticationToken =
////                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
////        LoginUser loginUser = (LoginUser) authenticationToken.getPrincipal();
////        this.user = null;
//        return new ResponseResult(200,"注销成功");
//    }
//}
