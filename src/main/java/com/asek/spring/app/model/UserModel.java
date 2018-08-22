package com.asek.spring.app.model;


import javax.persistence.*;

@Entity
@Table(name="USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long user_id;

    @Column(name="name")
    private String name;

    @Column(name="fave_colour")
    private String fave_colour;

    public void setUser_id(long user_id) { this.user_id = user_id; }

    public long getUser_id() {
        return user_id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFave_colour() {
        return fave_colour;
    }

    public void setFave_colour(String fave_colour) {
        this.fave_colour = fave_colour;
    }
}
