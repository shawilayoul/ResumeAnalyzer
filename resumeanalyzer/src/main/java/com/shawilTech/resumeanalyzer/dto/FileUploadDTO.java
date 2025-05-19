package com.shawilTech.resumeanalyzer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadDTO {

    @Schema(type = "string", format = "binary", description = "Resume file")
    private MultipartFile file;

    // Getter and Setter
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
