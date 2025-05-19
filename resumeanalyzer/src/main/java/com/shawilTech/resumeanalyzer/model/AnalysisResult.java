package com.shawilTech.resumeanalyzer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalysisResult {
    @Id @GeneratedValue
    private long id;
    private  String feedback;

    @ManyToOne
    private  Resume resume;
}
