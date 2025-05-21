package com.shawilTech.resumeanalyzer.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String email;
    private  String  password;
    private  String role; // "user" , "admin"
}
