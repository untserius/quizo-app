package com.serius.quizo.service;

import com.serius.quizo.dto.QuestionDto;
import com.serius.quizo.entity.Question;

import java.util.List;

public interface QuestionService {
    public QuestionDto addQuestion(QuestionDto questionDto);
    public List<Question> readAllQuestion();
    public List<Question> readQuestionsByCategory(String category);
}
