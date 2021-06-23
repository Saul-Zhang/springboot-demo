package xyz.zsly.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zsly.springboot.springsecurity.entity.User;

/**
 * @author zhang song
 * @date 2021/6/23 15:42
 */
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
