package cn.rayest.InAction.soundSystem;

import cn.rayest.InAction.soundSystem.beatlesCD.HardDaysNight;
import cn.rayest.InAction.soundSystem.beatlesCD.Revolver;
import cn.rayest.InAction.soundSystem.beatlesCD.SgtPeppers;
import cn.rayest.InAction.soundSystem.beatlesCD.WhiteAlbum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@Configuration
@ComponentScan // 默认扫描同包及其子包中有特定注 spring 注解的包
public class CDPlayerConfig {
    // 在 JavaConfig 中声明 Bean, 并将该对象注册为 spring 上下文的一个 Bean
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    // 根据条件注入相应的 CD
    @Bean
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        }
        if (choice == 1) {
            return new WhiteAlbum();
        }
        if (choice == 2) {
            return new HardDaysNight();
        }
        return new Revolver();
    }

    // 注入 CDPlayer
    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }

    // 注入 Another CDPlayer, 与如上注入将会得到相同的实例对象
    @Bean
    public CDPlayer anotherCDPlayer(){
        return new CDPlayer(sgtPeppers());
    }

}
