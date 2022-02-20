package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.CustomEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomEventRepository extends JpaRepository<CustomEvent, Long> {
}