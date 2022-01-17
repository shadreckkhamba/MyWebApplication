package com.example.demo.MyWebApplication;

import javax.persistence.*;
@Entity
@Table
public class MyWebApplication {
    @Id
    @SequenceGenerator(
            name= "application_sequence",
            sequenceName = "application_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "application_sequence"
    )
    private Long id;
    private String name;
    private String category;
    private String developer;
    private String email;

    public MyWebApplication() {
    }

    public MyWebApplication(Long id, String name, String category, String developer, String email) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.developer = developer;
        this.email = email;
    }

    public MyWebApplication(String name, String category, String developer, String email) {
        this.name = name;
        this.category = category;
        this.developer = developer;
        this.email = email;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeveloper() {
        return developer;
    }
    public void setDeveloper(String developer) {

        this.developer=developer;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", developer='" + developer + '\'' +
                   ",email=" +email+'}';
    }

}
