package com.buraktan.app.core.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(generator = "movie", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "movie", sequenceName = "MOVIE_ID_SEQ")
    private Long id;

    @Column(length = 50)
    @Size(max = 50)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date publishDate;

    private Double rating;

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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " - " + publishDate;
    }
}
