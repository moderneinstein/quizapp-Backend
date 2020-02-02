package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;

import java.util.List;

public interface QuestionServiceInterface {
    void addQuestions(QuestionDTO questionDTO);
    List<Question> getQuestions(String category);
    List<Question> getQuiz(String quizName);
}