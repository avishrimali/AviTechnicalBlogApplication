package technicalblog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
//    It is optional to use the @Column annotation unless you want to override the default column naming,
//    which defaults to the attribute name. Here, we do not want to override the column name; therefore,
//    it is not necessary to use the @Column annotation
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    // To define one to one mapping with user profile. Here User is parent and User_Profile is a child entity.
    //CascadeType represents that if change happens to parent entity then related entity should also be changed.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    A user can have a unique profile, and there can be only one user mapped to one user profile.
//    Therefore, there exists One to One mapping between the users table and the user_profile table.
//    The profile_id column in the users table is a foreign key and references the id column (primary key)
//    in the user_profile table. Note that in One to One mapping, we generally create a separate column as
//    a foreign key in any table referencing the primary key of the other table to specify the relationship between them.
    @JoinColumn(name="profile_id")
    private UserProfile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    //If you remove the user the respective post also will be removed
    // For one to many Fetch type is lazy
    private List<Post> posts = new ArrayList<>();

    /*If a User object propagates through the REMOVE operation, the Post object referencing that particular User object must
    also propagate through the same operation. For example, if a record in the ‘users’ table is deleted, all the records
    in the posts table referencing that particular user record must also be deleted. Therefore, cascade = CascadeType.REMOVE
    is used to implement this functionality. But, if a User object propagates through PERSIST, REFRESH, MERGE, or DETACH,
    the Post object must not propagate through all these operations. For example, if a user is registered or user details
    are updated in the application, all the posts related to that user must not undergo any change. Therefore,
    cascade = CascadeType.ALL is not used.*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
