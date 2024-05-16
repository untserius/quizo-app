package com.serius.quizo.controller;

import com.serius.quizo.dto.QuestionDto;
import com.serius.quizo.entity.Question;
import com.serius.quizo.service.QuestionService;
import com.serius.quizo.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz/")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<?> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        String quiz = quizService.createQuiz(category, numQ, title);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDto>> getQuizQuestions(@PathVariable long id) {
        List<QuestionDto> quizQuestions = quizService.getQuizQuestions(id);
        return new ResponseEntity<>(quizQuestions, HttpStatus.OK);
    }
}
