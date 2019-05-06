package me.jems;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class UserController extends AppController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/createuser")
    public Users createUser(@RequestBody Map<String, String> body){
       String username = body.get("username");
       String hashedPassword = body.get("hashedPassword");
        return userRepository.save(new Users(username, hashedPassword));
    }

    @PostMapping("/authenticate")
    public Boolean authenticate(@RequestBody Map<String, String> body) {
        if(!body.isEmpty()) {
            String username = body.get("username");
            String hashedPassword = body.get("hashedPassword");
            ArrayList<Users> users = (ArrayList<Users>) userRepository.findByUserName(username);
            for(Users u: users) {
                if(u.getHashedPassword().equals(hashedPassword)) {
                    session_id = true;
                    return true;
                }
            }
        }

        return session_id;
    }


}
