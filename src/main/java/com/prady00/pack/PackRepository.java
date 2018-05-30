package com.prady00.pack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Long>{

	List<Pack> findAllByEmail(String email);

}
