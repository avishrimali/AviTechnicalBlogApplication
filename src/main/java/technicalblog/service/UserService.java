package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import technicalblog.model.User;
import technicalblog.repository.PostRepository;
import technicalblog.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user){
//        return user.getUsername().equals("validuser")? true: false;
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if(null !=existingUser){
            return existingUser;
        }
        return null;
    }

    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }
}
