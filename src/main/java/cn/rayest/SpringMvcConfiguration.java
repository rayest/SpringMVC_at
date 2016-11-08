package cn.rayest;

import cn.rayest.statics.StaticInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Rayest on 2016/11/8 0008.
 */
@Configuration
@EnableWebMvc
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
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    // 配置拦截器
    @Bean
    public StaticInterceptor staticInterceptor(){
        return new StaticInterceptor();
    }
    // 重写方法，注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(staticInterceptor());
    }

    // 重写方法，注册视图控制层。访问路径和视图名称：/shortcut
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/shortcut").setViewName("/shortcut");
    }

    // 重写方法，不能忽略请求参数 “.” 等等
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
         configurer.setUseSuffixPatternMatch(false);
    }
}
