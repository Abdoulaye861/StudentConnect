package com.students.dao;

import com.students.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark,Long> {
	
	

}

