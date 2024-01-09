package com.degra.songs.controller;

import com.degra.songs.entity.Department;
import com.degra.songs.error.DepartmentNotFoundException;
import com.degra.songs.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartment(){
        LOGGER.info("Inside getDepartment of DepartmentController");
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public String deleleDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(departmentId);
        return "Deleted succesfully";
    }

    @GetMapping("/{id}")
    public Department fetchDepartementById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return  departmentService.fetchDepartementById(departmentId);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(department, departmentId);
    }

    @GetMapping("/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }


}
