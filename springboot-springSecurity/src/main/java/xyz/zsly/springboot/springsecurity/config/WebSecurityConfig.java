package xyz.zsly.springboot.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import xyz.zsly.springboot.springsecurity.service.JdbcUserDetailsService;

/**
 * @author zhang song
 * @date 2021/6/20 22:24
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JdbcUserDetailsService jdbcUserDetailsService;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 关闭csrf和cors
    http.csrf().disable().cors().disable()
        // 放行这几个请求
        .authorizeRequests().antMatchers("/login/**", "/logout", "/error/**").permitAll()
        // 其他请求都要验证
        .anyRequest().authenticated()
        .and()
        // 表明是基于表单的身份验证
        .formLogin();
    // 配置登录页面,就是可以把默认的登录页面换成自定义的
    //.loginPage("/login")
    // 登录表单的action
    //.loginProcessingUrl("/toLogin")
    // 登录成功后处理器，比如对于localhost:8080/hello?redirect=www.zsly.xyz，登录成功后重定向到redirect
    //.successHandler(new MySuccessHandler())
    // 登录失败重定向到这个请求
    //.failureUrl("/login?error")
    //.and()
    //.logout()
    //登出后跳转处理器
    //.logoutSuccessHandler(new MyLogoutSuccessHandler())

  }

  /**
   * 在内存中指定用户
   */
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication()
//        //指定加密方法
//        .passwordEncoder(passwordEncoder())
//        // 用户名
//        .withUser("zhangsong")
//        // 密码
//        .password(passwordEncoder().encode("zsly.xyz"))
//        //角色
//        .roles("USER")
//        //使用and添加多个用户
//        .and().withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
//  }

  /**
   * 加密方式
   */
  private PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 从数据库中获取用户
    auth.userDetailsService(jdbcUserDetailsService).passwordEncoder(passwordEncoder());
    // 从内存中获取用户，其实这两个是可以共存的
//    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
  }

  @Override
  @Bean
  public UserDetailsService userDetailsService() {
    // 在内存中生成一个用户
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(
        User.builder()
            .username("zhangsong")
            .password(passwordEncoder().encode("zsly"))
            .roles("USER")
            .build());
    return manager;
  }

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("zsly.xyz"));
  }
}
