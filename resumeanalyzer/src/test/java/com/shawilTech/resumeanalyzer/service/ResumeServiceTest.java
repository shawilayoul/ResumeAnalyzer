package com.shawilTech.resumeanalyzer.service;

import com.shawilTech.resumeanalyzer.repository.ResumeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class ResumeServiceTest {

    @Mock
    private ResumeRepository resumeRepository;

    @Mock
    private  OpenAIService openAIService;

    @InjectMocks
    private  ResumeService resumeService;

    @Test
    void  testAnalzeresume() throws IOException{
        MultipartFile mockFile = new MockMultipartFile("resume.pdf","resume.pdf", "application/pdf", "Test content".getBytes());
        when(openAIService.analyzeresume())
    }
}
