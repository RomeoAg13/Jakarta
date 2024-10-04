package org.efrei.demo.controllers;


import org.efrei.demo.dto.CreateAwards;
import org.efrei.demo.dto.CreateMovie;
import org.efrei.demo.models.Awards;
import org.efrei.demo.services.AwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/awards")
public class AwardsController {
    private final AwardsService awardsService;

    @Autowired
    public AwardsController(AwardsService awardsService) {
        this.awardsService = awardsService;
    }

    @GetMapping
    public ResponseEntity<List<Awards>> findAll(){
        return new ResponseEntity<>(awardsService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Awards awards = awardsService.findById(id);
        if(awards == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        awardsService.deleteById(id);
        return new ResponseEntity<>(awards, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateAwards createAwards) {
        awardsService.create(createAwards);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
