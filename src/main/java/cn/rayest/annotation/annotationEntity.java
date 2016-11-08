package cn.rayest.annotation;

/**
 * Created by Rayest on 2016/11/8 0008.
 */
public class AnnotationEntity {
    private Long id;
    private String name;

    public AnnotationEntity() {
    }

    public AnnotationEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
