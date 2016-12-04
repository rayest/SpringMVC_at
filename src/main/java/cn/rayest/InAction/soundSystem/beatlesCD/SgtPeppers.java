package cn.rayest.InAction.soundSystem.beatlesCD;

import cn.rayest.InAction.soundSystem.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
// Beatles 1967年的专辑
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
