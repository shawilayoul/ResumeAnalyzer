package com.shawilTech.resumeanalyzer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shawilTech.resumeanalyzer.dto.ResumeUploadResponseDTO;
import com.shawilTech.resumeanalyzer.model.Resume;
import com.shawilTech.resumeanalyzer.repository.ResumeRepository;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResumeServiceTest {

    @Mock
    private ResumeRepository resumeRepository;

    @Mock
    private OpenAIService openAIService;

    @InjectMocks
    private ResumeService resumeService;

    private Tika tika;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tika = new Tika(); // For expected text
    }

    @Test
    void testAnalyzeResume_success() throws IOException, TikaException {
        // Arrange
        String sampleText = "Sample resume content";
        String openAIResponse = "{ \"choices\": [ { \"message\": { \"content\": \"Great resume.\" } } ] }";
        MockMultipartFile file = new MockMultipartFile("file", "resume.txt", "text/plain", sampleText.getBytes());

        when(openAIService.analyzeresume(anyString())).thenReturn(openAIResponse);
        when(resumeRepository.save(any(Resume.class))).thenAnswer(invocation -> {
            Resume r = invocation.getArgument(0);
            r.setId(1L); // Simulate DB ID assignment
            return r;
        });

        // Act
        ResumeUploadResponseDTO response = resumeService.analzeResume(file);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getResumeId());
        assertEquals("resume.txt", response.getFilename());
        assertEquals("Great resume.", response.getFeedback());

        verify(openAIService, times(1)).analyzeresume(contains("Sample"));
        verify(resumeRepository, times(1)).save(any(Resume.class));
    }

    @Test
    void testAnalyzeResume_invalidJsonFallback() throws IOException, TikaException {
        String sampleText = "Invalid JSON test";
        String badJson = "Not a JSON";
        MockMultipartFile file = new MockMultipartFile("file", "invalid_resume.txt", "text/plain", sampleText.getBytes());

        when(openAIService.analyzeresume(anyString())).thenReturn(badJson);
        when(resumeRepository.save(any(Resume.class))).thenAnswer(invocation -> {
            Resume r = invocation.getArgument(0);
            r.setId(1L);
            return r;
        });

        ResumeUploadResponseDTO response = resumeService.analzeResume(file);

        assertEquals("Unable to parse feedback.", response.getFeedback());
    }
}
