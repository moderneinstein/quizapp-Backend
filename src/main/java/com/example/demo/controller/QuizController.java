package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.QuizDTO;
import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.service.QuizServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/quiz")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuizController {
    @Autowired
    private QuizServiceInterface quizService;

    @PostMapping("/addQuiz")
    public ResponseEntity<String> addQuiz(@RequestBody QuizDTO quizDTO) {
        try {
            Quiz quiz = new Quiz();
            BeanUtils.copyProperties(quizDTO, quiz);
            quizService.addQuiz(quiz);
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Failed to create Quiz", HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @GetMapping("/getQuizList")
    public BaseResponse<List<String>> getQuizList() {
        BaseResponse<List<String>> baseResponse = new BaseResponse<List<String>>();
        baseResponse.setData(quizService.getQuizList());
        baseResponse.setStatus("200");
        return baseResponse;
    }
}
