package org.example.models;


import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String duration;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
