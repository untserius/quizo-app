package com.serius.quizo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    @Column(name = "difficulty_level", nullable = false, length = 100)
    private String difficultyLevel;

    @Column(name = "option_1", nullable = false)
    private String option1;

    @Column(name = "option_2", nullable = false)
    private String option2;

    @Column(name = "option_3", nullable = false)
    private String option3;

    @Column(name = "option_4", nullable = false)
    private String option4;

    @Column(name = "question_title", nullable = false, length = 400)
    private String questionTitle;

    @Column(name = "right_answer", nullable = false, length = 400)
    private String rightAnswer;

}