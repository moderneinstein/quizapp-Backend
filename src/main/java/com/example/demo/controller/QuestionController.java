package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.Response;
import com.example.demo.entity.Question;
import com.example.demo.service.QuestionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/staticQuestions")
public class QuestionController {

    @Autowired
    QuestionServiceInterface questionService;

    @PostMapping(value = "/addQuestions")
    public void addQuestions(@RequestBody QuestionDTO questionDTO){
        questionService.addQuestions(questionDTO);
    }

//    http://10.177.68.85/staticQuestions/getQuestions/{category}
    @GetMapping(value = "/getQuestions/{category}")
    public Response<List<Question>> getQuestions(@PathVariable("category") String category) {
        Response<List<Question>> responses = new Response<>();

        try {
            List<Question> list = questionService.getQuestions(category);
            responses.setStatus(true);
            responses.setData(list);
        }
        catch (Exception e){
            responses.setStatus(false);
        }
        return responses;
    }
}