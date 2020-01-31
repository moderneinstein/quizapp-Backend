package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;

import java.util.List;

public interface QuestionServiceInterface
{
    public void addQuestions(QuestionDTO questionDTO);
    public List<Question> getQuestions(String category);

}