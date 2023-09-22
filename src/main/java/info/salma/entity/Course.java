package info.salma.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    private long id;
    private String name;
    public Course() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public Course(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }

}
