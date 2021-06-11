package xyz.zsly.springbootjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author zhang song
 * @date 2021/6/10 17:02
 */
@Entity
@Data
public class Role {
  @Id
  @Column(length = 36)
  private String id;
  private String name;
}
