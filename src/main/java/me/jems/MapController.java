package me.jems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Map;

@RestController
public class MapController extends SessionController {


    @Autowired
    MapsRepository mapsRepository;

    @PostMapping("/addstore")
    public ResponseEntity<Maps> storeLocator(@RequestBody Map<String, String> body) {
        String store_address = body.get("store_address");
        String city = body.get("city");
        if (store_address != null && city != null) {
            Maps maps = new Maps(store_address, city);
            //write location to db
            mapsRepository.save(maps);
            //send response
            HttpHeaders responseHeaders = new HttpHeaders();
            return new ResponseEntity<>(maps, responseHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getstorelocation")
    public ResponseEntity <ArrayList<Maps>> getLocation(@RequestParam(value="city") String city){
        ArrayList<Maps> store_address = (ArrayList<Maps>) mapsRepository.findStoreByCity(city);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(store_address, responseHeaders, HttpStatus.OK);

        }

}

