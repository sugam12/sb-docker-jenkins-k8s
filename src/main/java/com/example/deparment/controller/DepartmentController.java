package com.example.deparment.controller;

import com.example.deparment.entity.Department;
import com.example.deparment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity saveDepartment(@RequestBody Department department) {
        return ResponseEntity.ok().body(departmentService.saveDepartment(department));
    }

    @GetMapping()
    public ResponseEntity getDepartment() {
        List<Department> departmentList = departmentService.findAll();
        if (departmentList.isEmpty()) {
            return ResponseEntity.ok().body("No department found");
        } else {
            return ResponseEntity.ok().body(departmentList);
        }
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        Department department = departmentService.findById(departmentId);
        return ResponseEntity.ok().body(department);
    }

}
