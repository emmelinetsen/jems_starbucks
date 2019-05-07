package me.jems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Map;

@RestController
public class UserController extends SessionController {

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
    public ResponseEntity<Sessions> authenticate(@RequestBody Map<String, String> body) {
        if(!body.isEmpty()) {
            String username = body.get("username");
            String hashedPassword = body.get("hashedPassword");
            if(username != null && hashedPassword != null) {
                ArrayList<Users> users = (ArrayList<Users>) userRepository.findByUserNameEquals(username);
                for(Users u: users) {
                    if(u.getHashedPassword().equals(hashedPassword)) {
                        //add new session
                        return new ResponseEntity<>(newSession(username), HttpStatus.OK);
                    }
                }
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Sessions> logout(@RequestParam(value="session_id") String id) {
        if(verify(Integer.parseInt(id)) != null){
            deleteSession(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
