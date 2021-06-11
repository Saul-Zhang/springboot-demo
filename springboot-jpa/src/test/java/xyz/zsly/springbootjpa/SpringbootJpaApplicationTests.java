package xyz.zsly.springbootjpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import xyz.zsly.springbootjpa.model.Book;
import xyz.zsly.springbootjpa.model.DefUser;
import xyz.zsly.springbootjpa.repository.BookRepository;
import xyz.zsly.springbootjpa.service.UserService;

@SpringBootTest
class SpringbootJpaApplicationTests {

  @Test
  void contextLoads() {
  }

  @Autowired
  private UserService userService;


  @Autowired
  private BookRepository bookRepository;

  @Test
  public void getAll() {
    List<DefUser> all = userService.getAll();
    for (DefUser defUser : all) {
      System.out.println(defUser.getBooks());
      Set<Book> books = defUser.getBooks();
    }
  }

  @Test
  public void get() {
    System.out.println(userService.get("张三", ""));
  }

  @Test
  public void findByPriceRange() {
    System.out.println(bookRepository.findByPriceRange(100L, 200L));
  }

  @Test
  public void findByName() {
    System.out.println(bookRepository.findByName("悲惨"));
  }

  @Test
  public void   getBook() {
    String bookId = "1";
    String bookName = "世界";
    Specification<Book> specification = (root, criteriaQuery, criteriaBuilder) -> {
      ////用于存放查询条件的集合
      List<Predicate> predicates = new ArrayList<>();
      // 条件1：bookId等于book表的id
      predicates.add(criteriaBuilder.equal(root.get("id"), bookId));
      // 条件2：根据bookName模糊查找
      predicates.add(criteriaBuilder.like(root.get("name"), "%" + bookName + "%"));
      // 还可以加其他条件，比如between，大于小于，关联表等
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
    List<Book>  books= bookRepository.findAll(specification);
  }
}
