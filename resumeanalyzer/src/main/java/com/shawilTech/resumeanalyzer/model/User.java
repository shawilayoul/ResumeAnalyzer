package com.shawilTech.resumeanalyzer.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String email;
    private  String  password;
    private  String role; // "user" , "admin"
}
