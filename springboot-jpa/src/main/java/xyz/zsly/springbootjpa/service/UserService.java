package xyz.zsly.springbootjpa.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.zsly.springbootjpa.model.DefUser;
import xyz.zsly.springbootjpa.repository.UserRepository;

/**
 * @author zhang song
 * @date 2021/6/3 18:56
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<DefUser> getAll() {
    return userRepository.findAll();
  }

  public List<DefUser> get(String name, String email) {
    Specification<DefUser> specification = (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> predicateList = new ArrayList<>();
      if (name != null) {
        predicateList.add(criteriaBuilder.equal(root.get("name"), name));
      }
      return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
    };
    return userRepository.findAll(specification);
  }


}
