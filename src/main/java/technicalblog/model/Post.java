package technicalblog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER)
    // For many post there will be one user but reverse is not true.
    @JoinColumn(name= "user_id")
    private User user;
//    A user can upload multiple posts, but a post is mapped to only one user. Therefore, there exists One to Many mapping between
//    the users table and the posts table. The user_id column in the posts table is a
//    foreign key and references the id column (primary key) in the users table. Note that in One to Many or Many to One mapping,
//    we generally create a separate column as a foreign key on the Many side of the relationship referencing the primary key of
//    the other table on the One side of the relationship to specify the relationship between them.


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

//    A post can have multiple categories, and there can be multiple posts under one category.
//    Therefore, there exists Many to Many mapping between the posts table and categories table in the database.
//    Note that in Many to Many mapping, a new join table is created containing two columns and both the columns are primary keys
//    of both the tables. This is how a relationship is specified between two tables in Many to Many mapping. Hence, in this case,
//    a new join table will be created with two columns. The first column will be the ‘id’ column of the ‘posts’ table and will act
//    as a foreign key referencing the ‘id’ column in the ‘posts’ table. The second column will be the ‘id’ column of the ‘categories’
//    table and will act as a foreign key referencing the ‘id’ column in the ‘categories’ table.

    @Transient// so these fields are stateless and we don't need those in db as we are providing these options in UI.
    private String springBlog;

    @Transient
    private String javaBlog;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getSpringBlog() {
        return springBlog;
    }

    public void setSpringBlog(String springBlog) {
        this.springBlog = springBlog;
    }

    public String getJavaBlog() {
        return javaBlog;
    }

    public void setJavaBlog(String javaBlog) {
        this.javaBlog = javaBlog;
    }
}
