package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepositoryInterface;
import com.example.demo.service.QuizServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizServiceInterface {
    @Autowired
    QuizRepositoryInterface quizRepository;

    @Override
    public List<String> getQuizList() {
//        return quizRepository.findAll().stream().map(Quiz::getQuizName).collect(Collectors.toList());
        List<Quiz> quizList = quizRepository.findAll();

        List<String> returnList = new ArrayList<>();
        for (Quiz quiz:quizList)
        {
            returnList.add(quiz.getQuizName());
        }
        return returnList;
    }


    @Override
    public void addQuiz(Quiz quiz) {
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        if(quiz.getEnd().getTime() < ts.getTime()-1800)
            return;
        quizRepository.save(quiz);

//        System.out.println("Current Time Stamp: "+ts);
//        System.out.println("date" + ts.getDate());
//        System.out.println("time" + ts.getTime());

    }

    @Override
    public Optional<Quiz> getQuiz(String quizName) {
//        if(quizRepository.findById(quizName).isPresent())
            return quizRepository.findById(quizName);
//        return null;
    }

    @Override
    public List<Quiz> getAll(){
        return quizRepository.findAll();
    }
}
