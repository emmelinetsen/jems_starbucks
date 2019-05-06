package me.jems;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AddCardController {

    @Autowired
    CardRepository cardRepository;

    @PostMapping("/add")
    public Cards addCard(@RequestBody Map<String, String> body){
        String card = body.get("card");
        double amt = Double.parseDouble(body.get("amt"));

        return cardRepository.save(new Cards(card, amt));
    }

    @GetMapping("/getUserCards")
    public List<Cards> index(){
        return cardRepository.findAll();
    }

}
