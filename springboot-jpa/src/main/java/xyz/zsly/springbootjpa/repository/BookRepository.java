package xyz.zsly.springbootjpa.repository;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.zsly.springbootjpa.model.Book;

/**
 * @author zhang song
 * @date 2021/6/11 11:24
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String>,
    JpaSpecificationExecutor<Book> {
//  @Query(value = "select b from Book b where b.price>:price1 and b.price<:price2 ")
//  List<Book> findByPriceRange(@Param("price1")long price1, @Param("price2") long price2);

  @Query(value = "select b from Book b where b.price>?1 and b.price<?2 ")
  List<Book> findByPriceRange(long price1, long price2);

  @Query(value = "select * from book b where b.name like %?%", nativeQuery = true)
  List<Book> findByName(String name);
}
