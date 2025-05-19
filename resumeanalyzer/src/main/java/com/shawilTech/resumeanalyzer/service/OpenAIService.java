package com.shawilTech.resumeanalyzer.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.Map;
=======
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c

@Service
public class OpenAIService {

   private  final WebClient webClient;
<<<<<<< HEAD
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

=======

   public  OpenAIService(WebClient.Builder webClientBuilder){
       this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
   }

   public  String analyzeresume(String text){
       return  webClient.post()
               .uri("/chat/completions")
               .header("Authorization","Bearer OPENAI_API8KEY")
               .bodyValue(text)
               .retrieve()
               .bodyToMono(String.class)
               .block();
   }
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
}
