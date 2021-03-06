package cn.rayest;

import cn.rayest.converter.MessageConverter;
import cn.rayest.statics.StaticInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by Rayest on 2016/11/8 0008.
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("cn.rayest")
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    //重写方法，添加静态资源的放置目录和访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    // 配置拦截器
    @Bean
    public StaticInterceptor staticInterceptor() {
        return new StaticInterceptor();
    }

    // 重写方法，注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(staticInterceptor());
    }

    // 重写方法，注册视图控制层。访问路径和视图名称，如：/shortcut
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/shortcut").setViewName("/shortcut"); // 相当于一个没有业务逻辑的控制器
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/async").setViewName("/async");
    }

    // 配置文件上传解析器
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    // 重写方法，不能忽略请求参数 “.” 等等
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    // 仅添加一个自定义的 HttpMessageConverter，不覆盖默认注册的
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(messageConverter());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new MessageConverter();
    }

}
