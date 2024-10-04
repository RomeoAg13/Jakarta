package org.efrei.demo.models;

import jakarta.persistence.*;
import org.efrei.demo.globals.Category;
import org.efrei.demo.globals.CategoryAwards;

import java.util.List;

@Entity
public class Awards {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", length = 50)
    private String name;


    @ManyToMany
    @JoinTable(name = "movie_id")
    private List<Movie> movie;
    
    @ManyToMany
    @JoinTable(name="actor_id")
    private List<Actor> actor;

    public CategoryAwards getCategory() {
        return category;
    }

    public void setCategory(CategoryAwards category) {
        this.category = category;
    }


    @Enumerated(EnumType.STRING)
    private CategoryAwards category;

    public Awards(String name) {
        this.name = name;
    }

    public Awards() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
