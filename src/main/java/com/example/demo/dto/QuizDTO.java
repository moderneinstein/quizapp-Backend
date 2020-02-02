package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Id;
//import java.sql.Date;
import java.util.Date;
import java.sql.Timestamp;

@Data
public class QuizDTO {

    @org.springframework.data.annotation.Id
    private String quizName;
    private Date start;
    private Date end;

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
