package com.serius.quizo.service.impl;

import com.serius.quizo.dto.QuestionDto;
import com.serius.quizo.entity.Question;
import com.serius.quizo.entity.Quiz;
import com.serius.quizo.repository.QuestionRepository;
import com.serius.quizo.repository.QuizRepository;
import com.serius.quizo.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    @Override
    public String createQuiz(String category, int numQ, String title) {
        List<Question> randomQuestionsByCategory = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(randomQuestionsByCategory);

        quizRepository.save(quiz);

        return "done";
    }

    @Override
    public List<QuestionDto> getQuizQuestions(long id) {
        Optional<Quiz> byId = quizRepository.findById(id);
        if (byId.isPresent()) {
            List<Question> questionsfromDB = byId.get().getQuestions();
            List<QuestionDto> questionDtoList = questionsfromDB.stream().map(q -> mapToDto(q)).toList();
            return questionDtoList;
        }
        return Collections.emptyList();
    }

    public QuestionDto mapToDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestionTitle(question.getQuestionTitle());
        questionDto.setOption1(question.getOption1());
        questionDto.setOption2(question.getOption2());
        questionDto.setOption3(question.getOption3());
        questionDto.setOption4(question.getOption4());
        return questionDto;
    }

}


