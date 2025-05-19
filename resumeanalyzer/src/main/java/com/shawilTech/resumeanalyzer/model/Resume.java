package com.shawilTech.resumeanalyzer.model;
<<<<<<< HEAD

=======
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
import jakarta.persistence.*;
import lombok.*;

@Entity
<<<<<<< HEAD
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String filename;

    @Column(columnDefinition = "TEXT")
    private String extractedText;


    @ManyToOne
    private User user;
=======
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  long id;
    private  String filename;
    private  String extractedText;

    @ManyToOne
    private User  user;
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
}
