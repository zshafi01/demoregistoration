package com.example.demoregistoration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table (name= "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="FIRST_NAME")
    private String fName;
    @Column(name="LAST_NAME")
    private String lName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="CREATED_ON")
    @CreationTimestamp
    private Date createdOn;
    @Column(name="UPDATED_ON")
    @UpdateTimestamp
    private Date updatedOn;

}
