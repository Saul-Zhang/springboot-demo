package xyz.zsly.springbootjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * @author zhang song
 * @date 2021/6/10 17:57
 */
@Entity
@Data
public class Book {
  @Id
  @Column(length = 36)
  private String id;
  private String name;
  private long price;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="user_id")
  private DefUser user;
}
