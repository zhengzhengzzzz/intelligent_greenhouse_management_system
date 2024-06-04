package cn.hist.greenHouse.filter;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.mapper.UserMapper;
import cn.hist.greenHouse.service.Impl.AuthServiceImpl;
import cn.hist.greenHouse.service.Impl.LoginUser;
import cn.hist.greenHouse.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Objects;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthServiceImpl authService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
//         获取token
        String token = request.getHeader("auth");
        if(StringUtils.hasText(token)){
//            放行，接下来是做token解析工作，放行给后面的处理器进行异常抛出
            filterChain.doFilter(request,response);
            return;
        }
//        解析token
        String userId;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RemoteException("token非法");
        }
//        从缓存中获取用户信息
        User loginUser = authService.user;
        if(Objects.isNull(loginUser)){
            throw new RemoteException("用户未登录");
        }
//        存入 SecurityContextHolder，为了做授权使用 FilterSecurityInterceptor
        
    }
}
