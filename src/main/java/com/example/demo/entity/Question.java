package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Question")
@Getter
@Setter
public class Question {

    @Id
    private String questionId;
    private String question;
    private List<String> answer;
    private String answerType;
    private String questionType;
    private String binaryFilePath;
    private String difficulty;
    private String category;

}