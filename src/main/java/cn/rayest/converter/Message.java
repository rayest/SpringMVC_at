package cn.rayest.converter;

/**
 * Created by Rayest on 2016/11/9 0009.
 */
public class Message {
    private long id;
    private String name;

    public Message(Long aLong, String message) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
