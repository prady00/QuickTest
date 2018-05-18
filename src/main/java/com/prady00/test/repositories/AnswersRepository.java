package com.prady00.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prady00.test.models.Answers;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long>{

}
