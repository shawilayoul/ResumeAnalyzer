package com.shawilTech.resumeanalyzer.controller;

import com.shawilTech.resumeanalyzer.dto.FileUploadDTO;
import com.shawilTech.resumeanalyzer.dto.ResumeUploadResponseDTO;
import com.shawilTech.resumeanalyzer.service.ResumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @Operation(
            summary = "Upload resume for analysis",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(implementation = FileUploadDTO.class)
                    )
            )
    )
    @PostMapping("/analyze")
    public ResponseEntity<ResumeUploadResponseDTO> uploadResume(
            @RequestPart("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(resumeService.analzeResume(file));
    }
}
