package com.buraktan.app.core.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 0,
            initialValue = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "yourTableGenerator")
    public Long id;

    @Column(length = 30)
    @Size(max = 30)
    private String name;

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

    @Override
    public String toString() {
        return id + " " + name;
    }
}
