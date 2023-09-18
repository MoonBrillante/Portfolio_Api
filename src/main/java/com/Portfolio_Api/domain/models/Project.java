package com.Portfolio_Api.domain.models;

import jakarta.persistence.*;

@Entity
@Table
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private  String technology;
    private String img;
    public Project() {
    }
    public Project(Integer id, String name, String description, String technology, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.img = img;
    }
    public Project(String name, String description, String technology, String img) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.img = img;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}