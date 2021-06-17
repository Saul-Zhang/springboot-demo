package xyz.zsly.springbootfilter.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;

/**
 * @author zhang song
 * @date 2021/5/25 10:32
 */
@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    System.out.println("AuthenticationFilter");
    // 要继续处理请求，必须添加 filterChain.doFilter()，不加的话状态码还是200，但是不会返回任何数据
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
