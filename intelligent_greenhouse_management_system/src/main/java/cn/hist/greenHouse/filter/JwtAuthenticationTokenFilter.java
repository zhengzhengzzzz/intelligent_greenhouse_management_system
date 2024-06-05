//package cn.hist.greenHouse.filter;
//
//import cn.hist.greenHouse.entity.User;
//import cn.hist.greenHouse.mapper.UserMapper;
//import cn.hist.greenHouse.service.Impl.AuthServiceImpl;
//import cn.hist.greenHouse.service.Impl.LoginUser;
//import cn.hist.greenHouse.service.Impl.UserServiceImpl;
//import cn.hist.greenHouse.util.JwtUtil;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private UserServiceImpl userService;
//    @Override
////    @Transactional
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////         获取token
//        // 获取请求头中的 Authorization 信息
//        if (request.getRequestURI().equals("/login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        String authorizationHeader = request.getHeader("Authorization");
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7);
//            System.out.println("token::::::::::::::::::" + token);
//            if (StringUtils.hasText(token)) {
////            放行，接下来是做token解析工作，放行给后面的处理器进行异常抛出
//                filterChain.doFilter(request, response);
//                return;
//            }
//
////        解析token
//            String userId;
//            try {
//                Claims claims = JwtUtil.parseJWT(token);
//                userId = claims.getSubject();
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RemoteException("token非法");
//            }
////        从缓存中获取用户信息
//            User loginUser = userMapper.findUserByUserId(userId);
//            System.out.println("loginUser：" + loginUser);
////        LoginUser loginUser = authService.user;
//            if (Objects.isNull(loginUser)) {
//                throw new RemoteException("用户未登录");
//            }
//
//            // 获取用户详细信息
//            UserDetails userDetails = userService.loadUserByUsername(loginUser.getUsername());
//
//            // 创建认证令牌
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                    userDetails, null,userDetails.getAuthorities());
//
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//            // 设置安全上下文
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
////            String role = loginUser.getRole();
////            // 创建权限列表
////            List<GrantedAuthority> authorities = new ArrayList<>();
////            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));  // 根据实际角色创建权限对象
//////        存入 SecurityContextHolder，为了做授权使用 FilterSecurityInterceptor
////            UsernamePasswordAuthenticationToken authenticationToken
////                    = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), null, authorities);
////            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
////        放行
//            filterChain.doFilter(request, response);
//        }
//    }
//}
