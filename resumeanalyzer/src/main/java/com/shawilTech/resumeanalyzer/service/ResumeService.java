package com.shawilTech.resumeanalyzer.service;

import com.shawilTech.resumeanalyzer.dto.ResumeUploadResponseDTO;
import com.shawilTech.resumeanalyzer.model.Resume;
import com.shawilTech.resumeanalyzer.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
<<<<<<< HEAD
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

=======
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private  final ResumeRepository resumeRepository;
    private  final  OpenAIService openAIService;
    private  final Tika tika = new Tika();// Appache Tika which is server

    public ResumeUploadResponseDTO analzeResume(MultipartFile file) throws IOException, TikaException {
        String text = tika.parseToString(file.getInputStream());
<<<<<<< HEAD
        String feedBackJson = openAIService.analyzeresume(text);

        // Parse the JSON response to extract only the assistant message content
        ObjectMapper mapper = new ObjectMapper();
        String extractedFeedback = "";

        try {
            JsonNode root = mapper.readTree(feedBackJson);
            extractedFeedback = root.path("choices").get(0).path("message").path("content").asText();
        } catch (Exception e) {
            // fallback if parsing fails
            extractedFeedback = "Unable to parse feedback.";
        }
=======
        String feedBack = openAIService.analyzeresume(text);
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c

        Resume resume = Resume.builder()
                .filename(file.getOriginalFilename())
                .extractedText(text)
                .build();

        resumeRepository.save(resume);

        return  ResumeUploadResponseDTO.builder()
                .resumeId(resume.getId())
                .filename(resume.getFilename())
<<<<<<< HEAD
                .feedback(extractedFeedback)
=======
                .feedback(feedBack)
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
                .build();
    }
}
