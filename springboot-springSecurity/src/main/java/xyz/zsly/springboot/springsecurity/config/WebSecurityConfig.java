package xyz.zsly.springboot.springsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhang song
 * @date 2021/6/20 22:24
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        //指定加密方法
        .passwordEncoder(passwordEncoder())
        // 用户名
        .withUser("zhangsong")
        // 密码
        .password(passwordEncoder().encode("zsly.xyz"))
        //角色
        .roles("USER")
        //使用and添加多个用户
        .and()
        .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    // 开启
//    http.authorizeRequests()
//        .anyRequest().permitAll();
//  }

  private PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Override
//  @Bean
//  public UserDetailsService userDetailsService() {
//    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//    manager.createUser(
//        User.withDefaultPasswordEncoder().username("zhangsong").password("zsly.xyz").roles("USER")
//            .build());
//    return manager;
//  }
}
