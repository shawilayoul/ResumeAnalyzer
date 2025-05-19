package com.shawilTech.resumeanalyzer.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.Map;

@Service
public class OpenAIService {

   private  final WebClient webClient;
   private final String apiKey;

    public  OpenAIService(WebClient.Builder webClientBuilder, @Value("${openai.api.key}") String apiKey){
       this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
       this.apiKey = apiKey;
   }

    public String analyzeresume(String text) {
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of("role", "user", "content", text)
                )
        );

        return webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
