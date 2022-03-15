package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import lombok.Data;

import javax.persistence.*;

@Getter
@Setter // ^tells Lombok to generate these for all the fields of the class^
@NoArgsConstructor // generates an empty constructor
@AllArgsConstructor // generates all-args constructor - requires one argument for every field in the class
@Entity // represents a table in a relational database
@Data
@Table(name = "criminals") // allows you to specify the details of the table
public class Criminal {

    @Id // marks a field as a primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue specifies that the primary key is automatically allocated by DB, GenerationType.IDENTITY ensures id auto-increments
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "manner_of_death", nullable = false)
    private String mod;

    @Column(name = "image_link", nullable = false)
    private String imageLink;

}
