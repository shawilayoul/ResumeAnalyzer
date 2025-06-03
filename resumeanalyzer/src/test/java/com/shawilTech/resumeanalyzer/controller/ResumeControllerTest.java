package com.shawilTech.resumeanalyzer.controller;

import com.shawilTech.resumeanalyzer.dto.ResumeUploadResponseDTO;
import com.shawilTech.resumeanalyzer.service.ResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ResumeController.class)
class ResumeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResumeService resumeService;

    @Test
    void testUploadResume_returnsAnalyzedData() throws Exception {
        // 1. Mock file and service response
        MockMultipartFile file = new MockMultipartFile(
                "file", "resume.pdf", MediaType.APPLICATION_PDF_VALUE, "dummy content".getBytes()
        );

        ResumeUploadResponseDTO mockResponse = ResumeUploadResponseDTO.builder()
                .resumeId(1L)
                .filename("john_resume.pdf")
                .feedback("Looks good!")
                .build();


        when(resumeService.analzeResume(file)).thenReturn(mockResponse);

        // 2. Perform request
        mockMvc.perform(multipart("/api/resumes/analyze").file(file))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resumeId").value(1))
                .andExpect(jsonPath("$.filename").value("john_resume.pdf"))
                .andExpect(jsonPath("$.feedback").value("Looks good!"));

    }
}
