package me.jems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class  PaymentController {

    @Autowired
    CardRepository cardRepository;

    @GetMapping("/cards")
    public List<Cards> index(){
        return cardRepository.findAll();
    }

/*    @RequestMapping("/pay")
    public Cards pay(@RequestParam(value="uid") String uid) {
        return new Cards(String.format(uid));
    }*/
}
