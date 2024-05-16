package com.serius.quizo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class QuestionDto {
    private Long id;
    @JsonIgnore
    private String category;
    @JsonIgnore
    private String difficultyLevel;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @JsonIgnore
    private String rightAnswer;
}
