package com.example.demo.service.serviceImpl;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepositoryInterface;
import com.example.demo.service.QuestionServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface {
    @Autowired
    QuestionRepositoryInterface questionRepository;

    @Override
    public void addQuestions(QuestionDTO questionDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO, question);
        questionRepository.save(question);
    }
    @Override
    public List<Question> getQuestions(String category) {
        return questionRepository.findAllByCategory(category);
    }
}