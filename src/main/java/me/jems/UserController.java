package me.jems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Users> createUser(@RequestBody Map<String, String> body){
       String username = body.get("username");
       String hashedPassword = body.get("hashedPassword");
       if(username != null && hashedPassword != null) {
           Users user = new Users(username, hashedPassword);
           userRepository.save(user);
           HttpHeaders responseHeaders = new HttpHeaders();
           return new ResponseEntity<>(user, responseHeaders, HttpStatus.OK);
       }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Users> authenticate(@RequestBody Map<String, String> body) {
        session_id = false;
        if(!body.isEmpty()) {
            String username = body.get("username");
            String hashedPassword = body.get("hashedPassword");
            if(username != null && hashedPassword != null) {
                ArrayList<Users> users = (ArrayList<Users>) userRepository.findByUserNameEquals(username);
                for(Users u: users) {
                    if(u.getHashedPassword().equals(hashedPassword)) {
                        session_id = true;
                        return new ResponseEntity<>(u, HttpStatus.OK);
                    }
                }
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
