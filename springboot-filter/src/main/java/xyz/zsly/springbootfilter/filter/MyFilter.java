package xyz.zsly.springbootfilter.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhang song
 * @date 2021/5/25 10:22
 */
@Component
@Order(1)
public class MyFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("MyFilter--init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    System.out.println("MyFilter--start");
    // 要继续处理请求，必须添加 filterChain.doFilter()，不加的话状态码还是200，但是不会返回任何数据
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("MyFilter--end");
  }

  @Override
  public void destroy() {
    System.out.println("MyFilter--destroy");
  }
}
