package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.User;
import technicalblog.service.PostService;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @RequestMapping("users/login")
    public String login(){
        return "users/login"; // i.e. folder under templates as users-> login.html
    }

    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration"; // i.e. folder under templates as users-> registration.html
    }

    // if only one attribute you don't need to explicitly tell it is value, it is by default.
    // also by default the Request method type is get so you don't need to explicitly mention.
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user){
        return "redirect:/posts";
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
//        If we don't include the model object with post service call it will not display all existing three posts
    }
}
