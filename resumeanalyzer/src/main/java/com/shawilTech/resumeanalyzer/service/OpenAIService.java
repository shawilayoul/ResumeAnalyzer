package com.shawilTech.resumeanalyzer.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenAIService {

   private  final WebClient webClient;

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
}
