package xyz.zsly.springbootfilter.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.zsly.springbootfilter.filter.MyFilter;
import xyz.zsly.springbootfilter.filter.TokenFilter;

/**
 * @author zhang song
 * @date 2021/6/16 15:42
 */
@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<TokenFilter> registerMyFilter() {
    //注册过滤器
    FilterRegistrationBean<TokenFilter> bean = new FilterRegistrationBean<>();
    //创建filter
    TokenFilter tokenFilter = new TokenFilter();
    //添加条件
    bean.setFilter(tokenFilter);
    bean.setOrder(2);
    // 匹配"/hello/"下面的所有url
    bean.addUrlPatterns("/hello/*");
    return bean;
  }
}
