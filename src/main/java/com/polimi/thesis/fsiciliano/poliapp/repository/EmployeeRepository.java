package com.polimi.thesis.fsiciliano.poliapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.polimi.thesis.fsiciliano.poliapp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}