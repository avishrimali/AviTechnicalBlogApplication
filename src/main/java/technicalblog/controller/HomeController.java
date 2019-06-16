package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    public HomeController(){
        System.out.println("**** Home Controller ****");
    }

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model){

//        Post post= new Post();
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
//
//        model.addAttribute("posts", posts);

        model.addAttribute("posts", postService.getAllPosts());

        return "index";
    }
}
