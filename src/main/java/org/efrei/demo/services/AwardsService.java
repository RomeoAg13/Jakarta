package org.efrei.demo.services;

import org.efrei.demo.dto.CreateAwards;
import org.efrei.demo.models.Awards;
import org.efrei.demo.repository.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AwardsService {

    private final AwardsRepository repository;

    @Autowired
    public AwardsService(AwardsRepository repository) {
        this.repository = repository;
    }

    public List<Awards> findAll(){
        return repository.findAll();
    }

    public Awards findById(String id){
        return repository.findById(id).orElse(null);
    }


    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void create(CreateAwards createAwards) {
        Awards awards = new Awards();
        awards.setName(createAwards.getName());
        awards.setCategory(createAwards.getCategory());
        repository.save(awards);
    }

}
