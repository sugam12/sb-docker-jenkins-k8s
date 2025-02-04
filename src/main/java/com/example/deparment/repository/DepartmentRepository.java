package com.example.deparment.repository;

import com.example.deparment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
