package com.example.demo.repository;

import com.example.demo.entity.Quiz;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepositoryInterface extends MongoRepository<Quiz, String> {
//    List<String> findAllCategoryName();
    Optional<List<Quiz>> findAllByQuizName(String quizName);
//    Optional<List<String>> findAllByIdQuizName();

    @Query(value = "db.Quiz.find({},{start:0,end:0});")
    List<Quiz> findAllByIdQuizName();

}
