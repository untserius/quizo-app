package com.serius.quizo.controller;

import com.serius.quizo.dto.QuestionDto;
import com.serius.quizo.entity.Question;
import com.serius.quizo.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("add")
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto) {
        var addedQuestion = questionService.addQuestion(questionDto);
        return new ResponseEntity<>(addedQuestion, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllQuestion() {
        var allQuestion = questionService.readAllQuestion();
        return new ResponseEntity<>(allQuestion, HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<?> getQuestionsByCategory(@RequestParam String category) {
        List<Question> questions = questionService.readQuestionsByCategory(category);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
