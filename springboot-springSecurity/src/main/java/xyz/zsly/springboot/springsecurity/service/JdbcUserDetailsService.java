package xyz.zsly.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import xyz.zsly.springboot.springsecurity.entity.User;
import xyz.zsly.springboot.springsecurity.repository.UserRepository;

/**
 * @author zhang song
 * @date 2021/6/23 15:32
 */
@Service
public class JdbcUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String input) {
    User user = userRepository.findByUsername(input);
    if (user == null) {
      throw new BadCredentialsException("authenticationFailure.AccountNotFoundException");
    }
    // 通过User类中isEnabled()，isAccountNonExpired()等方法验证用户是否有效
    new AccountStatusUserDetailsChecker().check(user);
    return user;
  }
}
