package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Options")
public class Options {
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
