package xyz.zsly.springbootjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhang song
 * @date 2021/6/3 18:52
 */
@Entity
//@Data
@Getter
@Setter
public class DefUser {

  @Id
  @Column(length = 36)
  private String id;
  private String name;
  private String email;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private Set<Role> roles;

  @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
  private Set<Book> books;

  @Override
  public String toString() {
    return "DefUser{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", roles=" + roles +
//        ", books=" + books+
        '}';
  }
}
