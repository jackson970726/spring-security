package com.jackson.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 配置用户名和密码以及角色
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("tom")
                .password("111")
                .roles("admin");
    }

    /**
     * 过滤一些资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/image/**");
    }

    /**
     * 表单相关操作
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")//自定义登录页
                .loginProcessingUrl("/doLogin")//自定义登录接口
//                .usernameParameter("username")//自定义登录用户名参数
//                .passwordParameter("password")//自定义登录密码参数
//                .defaultSuccessUrl("/hello")
                .successForwardUrl("/hello")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
//                .logoutSuccessUrl("/login.html")
                .deleteCookies()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }
}
