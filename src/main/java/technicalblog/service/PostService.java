package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
//    @Autowired
//    private Post post;

    public PostService(){
        System.out.println("**** Post Service ****");
    }

    public List<Post> getAllPosts(){
//        Post post= new Post();
//        Model classes are not as reusable as classes like the service class. Dependency injection is useful when a class is generic
//        and one instance of the class can be re-used throughout the application to perform the same function, like getting a list of posts.
//        On the other hand, Post model objects can be used in various ways, and different objects of the  Post class are
//        required to represent different post data. For example, Data in post1 is different from post2.
//        Hence, models classes cannot be as easily and as often reused and hence we use the new operator to
//        instantiate objects of model classes instead of using dependency injection.

//        post.setTitle("post1");
//        post.setBody("post body 1");
//        post.setDate(new Date());
//
//        Post post1= new Post();
//        post1.setTitle("post2");
//        post1.setBody("post body 2");
//        post1.setDate(new Date());
//
//        Post post2= new Post();
//        post2.setTitle("post3");
//        post2.setBody("post body 3");
//        post2.setDate(new Date());
//
//        ArrayList<Post> posts= new ArrayList<>();
//        posts.add(post);
//        posts.add(post1);
//        posts.add(post2);

//        using jdbc

//        ArrayList<Post> posts= new ArrayList<>();
//        Connection connection=null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog", "ashrimali", "avinash.85");
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery("SELECT * FROM posts");
//            while(result.next()){
//                Post post= new Post();
//                post.setTitle(result.getString("title"));
//                post.setBody(result.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        // using entity manager

        return postRepository.getAllPosts();

    }


    public Post getOnePost(){

//        ArrayList<Post> posts= new ArrayList<>();

//        Post post= new Post();
//        post.setTitle("This is your valid post");
//        post.setBody("Valid post data.");
//        post.setDate(new Date());

//        Connection connection=null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog", "ashrimali", "avinash.85");
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery("SELECT * FROM posts where id=4");
//            while(result.next()){
//                Post post= new Post();
//                post.setTitle(result.getString("title"));
//                post.setBody(result.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return posts;

        return postRepository.getLatestPost();
    }

    public void createPost(Post post) {

        post.setDate(new Date());
        postRepository.createPost(post);
        System.out.println("New Post: "+ post);
    }

    public Post getPost(Integer postId){
        return postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        postRepository.deletePost(postId);
    }
}
