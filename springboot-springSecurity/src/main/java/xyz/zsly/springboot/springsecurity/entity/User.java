package xyz.zsly.springboot.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zhang song
 * @date 2021/6/23 15:43
 */
@Data
@Entity(name = "def_user")
public class User implements UserDetails {

  @Id
  @JsonIgnore
  private Long id;

  private String username;

  @JsonIgnore
  private String password;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
