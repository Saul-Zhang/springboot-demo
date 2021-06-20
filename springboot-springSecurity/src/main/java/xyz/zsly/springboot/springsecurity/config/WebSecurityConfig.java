package xyz.zsly.springboot.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author zhang song
 * @date 2021/6/20 22:24
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("root")
        .password("root")
        .roles("USER");
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
////    http.authorizeRequests().anyRequest().permitAll();
//  }

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
