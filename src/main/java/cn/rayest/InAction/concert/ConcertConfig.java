package cn.rayest.InAction.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }
}
