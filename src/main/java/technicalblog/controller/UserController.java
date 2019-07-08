package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    public String login(){
        return "users/login"; // i.e. folder under templates as users-> login.html
    }

    @RequestMapping("users/registration")
    public String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);

        model.addAttribute("User", user);
        return "users/registration"; // i.e. folder under templates as users-> registration.html
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        userService.registerUser(user);
        return "users/login";
    }

    // if only one attribute you don't need to explicitly tell it is value, it is by default.
    // also by default the Request method type is get so you don't need to explicitly mention.
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user, HttpSession httpSession){
//        return userService.login(user)? "redirect:/posts": "users/login";
        User existingUser = userService.login(user);
        if(null!=existingUser){
            httpSession.setAttribute("loggeduser", existingUser);// key loggeduser will be used in layout.html file
            return "redirect:/posts";
        }else{
            return "users/login";
        }
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession httpSession){
        httpSession.invalidate();
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
//        If we don't include the model object with post service call it will not display all existing three posts
    }


}
