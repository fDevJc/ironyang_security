package ironyang.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity(debug = true)  //스프링 시큐리티 필터가 스프링 필터체인에 등록
@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("WebSecurityConfig.filterChain");
        //Cross Site Request Forgery
        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin()
//                .usernameParameter("email")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/")
        ;

        return http.build();
    }
}
