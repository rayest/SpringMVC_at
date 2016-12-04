package cn.rayest.InAction.soundSystem;

import cn.rayest.InAction.soundSystem.beatlesCD.BlankDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {
    @Bean
    public CompactDisc sgtPeppers(){
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The beatles");
        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a little help from my friends");
        tracks.add("Lucky in the sky with diamonds");
        tracks.add("Getting better");
        tracks.add("Fixing a hole");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter (){
        return new TrackCounter();
    }
}
