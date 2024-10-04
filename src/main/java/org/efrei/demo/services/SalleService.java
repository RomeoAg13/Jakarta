package org.efrei.demo.services;


import org.efrei.demo.dto.CreateSalle;
import org.efrei.demo.models.Movie;
import org.efrei.demo.models.Salle;
import org.efrei.demo.repository.MovieRepository;
import org.efrei.demo.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;
    private final MovieService movieService;

    @Autowired
    public SalleService(SalleRepository salleRepository, MovieService movieService, MovieRepository movieRepository) {
        this.salleRepository = salleRepository;
        this.movieService = movieService;
    }

    public List<Salle> findAll(){
        // SELECT * FROM salle
        System.out.println(salleRepository.findAll());
        return salleRepository.findAll();
    }

    public void create(CreateSalle createSalle) {
            Salle salle = new Salle();
            Movie movie= movieService.findById(createSalle.getMovieId());
            salle.setMovie(movie);
            salle.setName(createSalle.getName());
            salle.setCapacite(createSalle.getCapacite());
            salleRepository.save(salle);
    }

    public Salle findById(String id) {
    return salleRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        salleRepository.deleteById(id);
    }

    public void update(String id, Salle salle) {
        Salle upadteSalle = findById(id);
        upadteSalle.setName(salle.getName());
        salleRepository.save(upadteSalle);
    }
}
