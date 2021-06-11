package xyz.zsly.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import xyz.zsly.springbootjpa.model.DefUser;

/**
 * @author zhang song
 * @date 2021/6/3 18:55
 */
@Repository
public interface UserRepository extends JpaRepository<DefUser, String>,
    JpaSpecificationExecutor<DefUser> {

}
