package com.degra.songs.service;

import com.degra.songs.entity.Department;
import com.degra.songs.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department fetchDepartementById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartment(Long departmentId) throws DepartmentNotFoundException;

    public Department updateDepartment(Department department, Long departmentId);

    public Department fetchDepartmentByName(String departmentName);
}



