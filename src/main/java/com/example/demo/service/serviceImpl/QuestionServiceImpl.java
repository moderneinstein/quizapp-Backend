package com.example.demo.service.serviceImpl;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Options;
import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuestionRepositoryInterface;
import com.example.demo.repository.QuizRepositoryInterface;
import com.example.demo.service.QuestionServiceInterface;
import com.example.demo.service.QuizServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionServiceImpl implements QuestionServiceInterface {
    @Autowired
    QuestionRepositoryInterface questionRepository;
    @Autowired
    QuizServiceInterface quizService;

    @Autowired
    QuizRepositoryInterface quizRepositoryInterface;

    @Override
    public void addQuestions(QuestionDTO questionDTO) {
        Question question = new Question();
        Options options = new Options();
        BeanUtils.copyProperties(questionDTO, question);
        BeanUtils.copyProperties(questionDTO.getOptions(), options);
        question.setOptions(options);
        questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestions(String category) {
        return questionRepository.findByCategory(category);
    }


    @Override
    public List<Question> getQuiz(String quizName) {
        List<Question> current_quiz = questionRepository.findByQuizName(quizName);
        Quiz quiz = quizRepositoryInterface.findById(quizName).get();
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        if(quiz.getEnd().getTime()-1800 < ts.getTime())
            return null;
        return current_quiz;
    }
}