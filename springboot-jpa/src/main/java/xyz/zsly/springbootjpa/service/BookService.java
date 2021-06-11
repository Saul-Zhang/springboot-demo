package xyz.zsly.springbootjpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zsly.springbootjpa.model.Book;
import xyz.zsly.springbootjpa.repository.BookRepository;

/**
 * @author zhang song
 * @date 2021/6/11 11:25
 */
@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;


}
