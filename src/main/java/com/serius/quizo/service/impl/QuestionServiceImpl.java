package com.serius.quizo.service.impl;

import com.serius.quizo.dto.QuestionDto;
import com.serius.quizo.entity.Question;
import com.serius.quizo.repository.QuestionRepository;
import com.serius.quizo.service.QuestionService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto) {

        Question question = new Question();

        question.setId(questionDto.getId());
        question.setCategory(questionDto.getCategory());
        question.setDifficultyLevel(questionDto.getDifficultyLevel());
        question.setQuestionTitle(questionDto.getQuestionTitle());
        question.setOption1(questionDto.getOption1());
        question.setOption2(questionDto.getOption2());
        question.setOption3(questionDto.getOption3());
        question.setOption4(questionDto.getOption4());
        question.setRightAnswer(questionDto.getRightAnswer());

        Question saved = questionRepository.save(question);

        QuestionDto dto = new QuestionDto();

        dto.setId(saved.getId());
        dto.setCategory(saved.getCategory());
        dto.setDifficultyLevel(saved.getDifficultyLevel());
        dto.setQuestionTitle(saved.getQuestionTitle());
        dto.setOption1(saved.getOption1());
        dto.setOption2(saved.getOption2());
        dto.setOption3(saved.getOption3());
        dto.setOption4(saved.getOption4());
        dto.setRightAnswer(saved.getRightAnswer());

        return dto;
    }

    @Override
    public List<Question> readAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> readQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }
}
