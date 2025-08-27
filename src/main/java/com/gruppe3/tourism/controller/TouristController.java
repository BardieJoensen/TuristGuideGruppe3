package com.gruppe3.tourism.controller;

import com.gruppe3.tourism.model.TouristAttraction;
import com.gruppe3.tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("attractions")

public class TouristController {
    private TouristService service;


    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttractions(){
        List<TouristAttraction> attractions = service.getAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionsByName(@PathVariable String name){
        TouristAttraction attraction = service.findAttractionByName(name);
        if (name != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /* @PostMapping("/add")

    @PostMapping("/update")

    @PostMapping("/delete/{name}") */

}
