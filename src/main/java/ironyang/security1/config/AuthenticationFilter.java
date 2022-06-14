package ironyang.security1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.security1.domain.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StreamUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //로그인 시도
        System.out.println("AuthenticationFilter.attemptAuthentication");
        try {
            //request body 받아오기
            String requestBody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);

            //ObjectMapper클래스를 통해 body(String) -> User 변환
            User user = new ObjectMapper().readValue(requestBody, User.class);

            //토큰 생성
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

            //AuthenticationManager를 통해 토큰 인증
            Authentication authenticate = getAuthenticationManager().authenticate(authenticationToken);

            return authenticate;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //로그인 성공
        System.out.println("AuthenticationFilter.successfulAuthentication");
    }
}
