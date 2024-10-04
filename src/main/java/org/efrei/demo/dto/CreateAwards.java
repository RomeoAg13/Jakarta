package org.efrei.demo.dto;

import org.efrei.demo.globals.CategoryAwards;

public class CreateAwards {
    private String name;
    private CategoryAwards category;
    private String movieId;
    private String actorId;


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public CategoryAwards getCategory(){
        return category;
    }
    public void setCategory(CategoryAwards category){
        this.category = category;
    }
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getActorId() {
        return actorId;
    }
    public void setActorId(String actorId) {
        this.actorId = actorId;
    }
}
