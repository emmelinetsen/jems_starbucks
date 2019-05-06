package me.jems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class  PaymentController extends AppController{

    @Autowired
    CardRepository cardRepository;

    @PostMapping("/pay")
    public ResponseEntity<Cards> pay(@RequestBody Map<String, String> body){
        if(authenticated){
            String card_id = body.get("card_id");
            Cards my_card = cardRepository.findByCard_id(card_id);
            //hard coded coffee price
            double new_amt = my_card.getAmt() -3.5;
            if(new_amt > 0){
                my_card.setAmt(new_amt);
                //write to card db
                //send response
                cardRepository.save(my_card);
                HttpHeaders responseHeaders = new HttpHeaders();
                return new ResponseEntity<>(my_card, responseHeaders, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
        } else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }


}
