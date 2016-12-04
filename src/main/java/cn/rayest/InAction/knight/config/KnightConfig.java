package cn.rayest.InAction.knight.config;

import cn.rayest.InAction.knight.BraveKnight;
import cn.rayest.InAction.knight.Knight;
import cn.rayest.InAction.knight.Quest;
import cn.rayest.InAction.knight.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);
    }

}
