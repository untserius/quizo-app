package com.serius.quizo.repository;

import com.serius.quizo.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category = :category order by random() limit :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
