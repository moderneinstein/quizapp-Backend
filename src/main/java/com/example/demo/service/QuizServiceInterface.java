package com.example.demo.service;

import com.example.demo.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizServiceInterface {
    List<String> getQuizList();
    void addQuiz(Quiz quiz);
    Optional<Quiz> getQuiz(String quizName);
    List<Quiz> getAll();
}
