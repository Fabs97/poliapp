package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}