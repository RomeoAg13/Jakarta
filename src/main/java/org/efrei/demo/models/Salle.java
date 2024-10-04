package org.efrei.demo.models;

import jakarta.persistence.*;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "capacite", nullable = false)
    private int capacite;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Salle(String name, int capacite){
        this.name = name;
        this.capacite = capacite;
    }

    public Salle() {

    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getCapacite(){
        return capacite;
    }

    public void setCapacite(int capacite){
        this.capacite = capacite;
    }
}
