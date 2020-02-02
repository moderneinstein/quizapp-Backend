package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;
import com.example.demo.service.QuestionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/staticQuestions")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class QuestionController {

    @Autowired
    private QuestionServiceInterface questionService;

    @PostMapping(value = "/addQuestions")
    public void addQuestions(@RequestBody QuestionDTO questionDTO){
        questionService.addQuestions(questionDTO);
    }

    @GetMapping(value = "/getQuestions/{category}")
    public BaseResponse<List<Question>> getQuestions(@PathVariable("category") String category) {
        BaseResponse<List<Question>> baseResponse = new BaseResponse<List<Question>>();
        List<Question> responses = questionService.getQuestions(category);
        baseResponse.setStatus("200");
        baseResponse.setData(responses);
        return baseResponse;
    }

    @GetMapping(value = "/getQuiz/{quizName}")
    public BaseResponse<List<Question>> getQuiz(@PathVariable("quizName") String quizName) {
        BaseResponse<List<Question>> baseResponse = new BaseResponse<List<Question>>();
        List<Question> responses = questionService.getQuiz(quizName);
        baseResponse.setStatus("200");
        baseResponse.setData(responses);
        return baseResponse;
    }
}