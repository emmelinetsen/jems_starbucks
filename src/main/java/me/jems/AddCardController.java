package me.jems;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AddCardController extends SessionController {



    @Autowired
    CardsRepository cardsRepository;

    @PostMapping("/addcard")
    public ResponseEntity<Cards> addCard(@RequestBody Map<String, String> body){

        int session_id = Integer.parseInt(body.get("session_id"));
        Sessions s = verify(session_id);

        if(s != null){
            String card_id = body.get("card_id");
            double amt = Double.parseDouble(body.get("amt"));
            Cards card = new Cards(card_id, s.getUsername(), amt);
            //write to card db
            cardsRepository.save(card);
            //send response
            HttpHeaders responseHeaders = new HttpHeaders();
            return new ResponseEntity<>(card, responseHeaders, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }

    @GetMapping("/getusercards")
    public ResponseEntity<ArrayList<Cards>> getUserCards(@RequestBody Map<String, String> body){

        int session_id = Integer.parseInt(body.get("session_id"));
        Sessions s = verify(session_id);

        if(s != null){
            ArrayList<Cards> user_cards = (ArrayList<Cards>) cardsRepository.findByUsernameContaining(s.getUsername());
            HttpHeaders responseHeaders = new HttpHeaders();
            return new ResponseEntity<>(user_cards, responseHeaders, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
