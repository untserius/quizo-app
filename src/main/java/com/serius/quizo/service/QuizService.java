package com.serius.quizo.service;

import com.serius.quizo.dto.QuestionDto;
import com.serius.quizo.entity.Quiz;

import java.util.List;

public interface QuizService {
    public String createQuiz(String category, int numQ, String title);
    public List<QuestionDto> getQuizQuestions(long id);
}
