package com.opeoluwa.quiz.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String question_title;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_answer;



}
