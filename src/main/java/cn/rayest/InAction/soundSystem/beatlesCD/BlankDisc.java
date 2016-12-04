package cn.rayest.InAction.soundSystem.beatlesCD;

import cn.rayest.InAction.soundSystem.CompactDisc;

import java.util.List;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void play() {

    }
}
