package com.shawilTech.resumeanalyzer.service;

import com.shawilTech.resumeanalyzer.dto.ResumeUploadResponseDTO;
import com.shawilTech.resumeanalyzer.model.Resume;
import com.shawilTech.resumeanalyzer.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private  final ResumeRepository resumeRepository;
    private  final  OpenAIService openAIService;
    private  final Tika tika = new Tika();// Appache Tika which is server

    public ResumeUploadResponseDTO analzeResume(MultipartFile file) throws IOException, TikaException {
        String text = tika.parseToString(file.getInputStream());
        String feedBack = openAIService.analyzeresume(text);

        Resume resume = Resume.builder()
                .filename(file.getOriginalFilename())
                .extractedText(text)
                .build();

        resumeRepository.save(resume);

        return  ResumeUploadResponseDTO.builder()
                .resumeId(resume.getId())
                .filename(resume.getFilename())
                .feedback(feedBack)
                .build();
    }
}
