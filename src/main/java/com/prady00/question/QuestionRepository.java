package com.prady00.question;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
