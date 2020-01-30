package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class QuestionDTO {
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
