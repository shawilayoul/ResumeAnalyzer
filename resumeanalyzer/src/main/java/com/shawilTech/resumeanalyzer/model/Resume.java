package com.shawilTech.resumeanalyzer.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
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
}
