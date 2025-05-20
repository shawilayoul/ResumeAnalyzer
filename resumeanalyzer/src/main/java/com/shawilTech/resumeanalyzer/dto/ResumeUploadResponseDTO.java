package com.shawilTech.resumeanalyzer.dto;
import jakarta.persistence.*;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumeUploadResponseDTO {
    @Schema(description = "ID of the uploaded resume")
    private  Long resumeId;

    @Schema(description = "Original filename")
    private  String filename;

    @Schema(description = "Feedback from AI analysis")
    private  String feedback;
}
