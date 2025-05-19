package com.shawilTech.resumeanalyzer.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
<<<<<<< HEAD
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
=======
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String email;
    private  String  password;
    private  String role; // "user" , "admin"
}
