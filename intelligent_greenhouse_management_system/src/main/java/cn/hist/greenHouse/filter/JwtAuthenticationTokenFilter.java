package cn.hist.greenHouse.filter;

import cn.hist.greenHouse.entity.User;
import cn.hist.greenHouse.mapper.UserMapper;
import cn.hist.greenHouse.service.Impl.AuthServiceImpl;
import cn.hist.greenHouse.service.Impl.LoginUser;
import cn.hist.greenHouse.service.Impl.UserServiceImpl;
import cn.hist.greenHouse.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            try {
                Claims claims = JwtUtil.parseJWT(token);
                String userId = claims.getSubject();
                if (userId != null) {
                    User loginUser = userMapper.findUserById(Integer.parseInt(userId));
                    if (loginUser != null) {
                        UserDetails userDetails = new LoginUser(loginUser, (List<GrantedAuthority>) getAuthorities(loginUser.getRole()));
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    } else {
                        throw new UsernameNotFoundException("User not found with ID: " + userId);
                    }
                } else {
                    throw new RuntimeException("Invalid JWT Token");
                }
            } catch (Exception e) {
                throw new ServletException("Failed to process JWT token", e);
            }
        }
        filterChain.doFilter(request, response);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role)); // 根据实际角色创建权限对象
        return authorities;
    }
}

