package com.buraktan.app.core.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 0,
            initialValue = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "yourTableGenerator")
    public Long id;

    @Column(length = 50)
    @Size(max = 50)
    public String name;

    public LocalDate publishDate;

    public Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY", foreignKey = @ForeignKey(name = "FK_MOVIE_CATEGORY"))
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + publishDate + " - " + rating + " - " + category.getId();
    }


}
