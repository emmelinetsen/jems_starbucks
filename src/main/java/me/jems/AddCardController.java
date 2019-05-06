package me.jems;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AddCardController extends AppController{



    @Autowired
    CardRepository cardRepository;

    @PostMapping("/addcard")
    public ResponseEntity<Cards> addCard(@RequestBody Map<String, String> body){
        if(authenticated){
            String card_id = body.get("card_id");
            double amt = Double.parseDouble(body.get("amt"));
            Cards card = new Cards(card_id, current_user, amt);
            //write to card db
            cardRepository.save(card);
            //send response
            HttpHeaders responseHeaders = new HttpHeaders();
            return new ResponseEntity<>(card, responseHeaders, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }

    @GetMapping("/getusercards")
    public ResponseEntity<ArrayList<Cards>> getUserCards(){
        if(authenticated){
            ArrayList<Cards> user_cards = (ArrayList<Cards>) cardRepository.findByUsernameContaining(current_user);
            HttpHeaders responseHeaders = new HttpHeaders();
            return new ResponseEntity<>(user_cards, responseHeaders, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
