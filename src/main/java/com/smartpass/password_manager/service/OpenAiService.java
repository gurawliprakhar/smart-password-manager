package com.smartpass.password_manager.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenAiService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .build();

    public String getPasswordSuggestion(String purpose) {
        String prompt = "Suggest a highly secure password for " + purpose +
                " (use special characters, length > 16)";

        String body = """
            {
              "model": "gpt-3.5-turbo",
              "messages": [{"role": "user", "content": "%s"}],
              "max_tokens": 50
            }
            """.formatted(prompt);

        return webClient.post()
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // or cache/store result
    }
}
