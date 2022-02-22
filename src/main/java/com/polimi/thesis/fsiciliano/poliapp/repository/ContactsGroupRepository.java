package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.ContactsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsGroupRepository extends JpaRepository<ContactsGroup, Long> {
}