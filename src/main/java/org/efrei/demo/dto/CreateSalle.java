package org.efrei.demo.dto;

public class CreateSalle {
    private String name;
    private int capacite;
    private String movieId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

}
