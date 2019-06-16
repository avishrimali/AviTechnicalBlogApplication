package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    @Autowired
    private Post post;

    public PostService(){
        System.out.println("**** Post Service ****");
    }

    public ArrayList<Post> getAllPosts(){
//        Post post= new Post();
//        Model classes are not as reusable as classes like the service class. Dependency injection is useful when a class is generic
//        and one instance of the class can be re-used throughout the application to perform the same function, like getting a list of posts.
//        On the other hand, Post model objects can be used in various ways, and different objects of the  Post class are
//        required to represent different post data. For example, Data in post1 is different from post2.
//        Hence, models classes cannot be as easily and as often reused and hence we use the new operator to
//        instantiate objects of model classes instead of using dependency injection.

        post.setTitle("post1");
        post.setBody("post body 1");
        post.setDate(new Date());

        Post post1= new Post();
        post1.setTitle("post2");
        post1.setBody("post body 2");
        post1.setDate(new Date());

        Post post2= new Post();
        post2.setTitle("post3");
        post2.setBody("post body 3");
        post2.setDate(new Date());

        ArrayList<Post> posts= new ArrayList<>();
        posts.add(post);
        posts.add(post1);
        posts.add(post2);

        return posts;
    }

    public ArrayList<Post> getOnePost(){

        ArrayList<Post> posts= new ArrayList<>();

        Post post= new Post();
        post.setTitle("This is your valid post");
        post.setBody("Valid post data.");
        post.setDate(new Date());

        posts.add(post);

        return posts;
    }

    public void createPost(Post post) {

    }
}
