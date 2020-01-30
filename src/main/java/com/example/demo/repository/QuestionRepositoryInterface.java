package com.example.demo.repository;

import com.example.demo.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepositoryInterface extends MongoRepository<Question, String> {
    List<Question> findAllByCategory(String category);
}