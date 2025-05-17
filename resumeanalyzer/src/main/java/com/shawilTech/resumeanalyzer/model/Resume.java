package com.shawilTech.resumeanalyzer.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
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
}
