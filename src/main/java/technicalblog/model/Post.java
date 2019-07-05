package technicalblog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// To make it a primary key
    @Column(name ="id")
    private Integer id;
//    @Transient// not persisted so ignores check if its present in db or not

    @Column(name ="date")
    public Date date;

    @Column(name ="title")
    public String title;

    @Column(name= "body")
    public String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
