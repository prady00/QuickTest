package com.prady00.test.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prady00.test.models.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {

}
