package com.ai.gemini_chat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/qna")
public class AIController {

    private final QnAService qnAService;

    // Manually defined constructor
    public AIController(QnAService qnAService) {
        this.qnAService = qnAService;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload) {
        String question = payload.get("question");
        String answer = qnAService.getAnswer(question);
        return ResponseEntity.ok(answer);
    }
    @GetMapping("/test")
    public String home() {
        return "Welcome to the Chatbot API!";
    }
}
