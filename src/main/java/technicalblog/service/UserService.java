package technicalblog.service;

import org.springframework.stereotype.Component;
import technicalblog.model.User;

@Component
public class UserService {

    public boolean login(User user){
//        return user.getUsername().equals("validuser")? true: false;
        if(user.getUsername().equals("validuser")){
            return true;
        }else {
            return false;
        }
    }
}
