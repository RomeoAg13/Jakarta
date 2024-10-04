package org.efrei.demo.controllers;


import org.efrei.demo.dto.CreateSalle;
import org.efrei.demo.models.Salle;
import org.efrei.demo.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salle")
public class SalleController {
    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public ResponseEntity<List<Salle>> findAll(){
        return new ResponseEntity<>(salleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> findById(@PathVariable String id){
        Salle salle = salleService.findById(id);
        if(salle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Salle salle = salleService.findById(id);

        if (salle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSalle createSalle){
        salleService.create(createSalle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Salle salle){
        salleService.update(id, salle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
