package com.shawilTech.resumeanalyzer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.List;
import java.util.Map;

@Service
public class OpenAIService {
    private final WebClient webClient;
    private final String apiKey;

    public OpenAIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();

        // Load .env file
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("OPENAI_API_KEY"); // Match your .env variable name

        // Validate key
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OPENAI_API_KEY not found in .env file");
        }
    }

    public String analyzeresume(String text) {

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo", // Valid model
                "messages", List.of(
                        Map.of("role", "user", "content", text)
                )
        );

        return webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + this.apiKey) // Use .env key
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                        .block();
    }
}