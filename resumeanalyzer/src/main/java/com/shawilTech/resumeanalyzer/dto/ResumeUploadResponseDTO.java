package com.shawilTech.resumeanalyzer.dto;
<<<<<<< HEAD
import jakarta.persistence.*;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
=======

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
public class ResumeUploadResponseDTO {
    @Schema(description = "ID of the uploaded resume")
    private  Long resumeId;

    @Schema(description = "Original filename")
    private  String filename;

    @Schema(description = "Feedback from AI analysis")
    private  String feedback;
}
