package me.jems;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AddCardController extends AppController{



    @Autowired
    CardRepository cardRepository;

    @PostMapping("/add")
    public String addCard(@RequestBody Map<String, String> body){
        if(session_id){

            String card = body.get("card");
            double amt = Double.parseDouble(body.get("amt"));
            return cardRepository.save(new Cards(card, amt)).toString();
        } else{
            return "Error, not logged in";
        }


    }

    @GetMapping("/getUserCards")
    public List<Cards> index(){
        return cardRepository.findAll();
    }

}
