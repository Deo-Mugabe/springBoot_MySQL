package com.degra.songs.service;

import com.degra.songs.entity.Department;
import com.degra.songs.error.DepartmentNotFoundException;
import com.degra.songs.repository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRespository departmentRespository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRespository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRespository.findAll();
    }



    @Override
    public Department fetchDepartementById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRespository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Departement Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> deptID = departmentRespository.findById(departmentId);
        if(!deptID.isPresent()){
            throw  new DepartmentNotFoundException("Departement Not Available");
        }
        departmentRespository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {

        Department depDB = departmentRespository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

       return departmentRespository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRespository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
