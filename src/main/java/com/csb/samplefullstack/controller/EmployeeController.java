package com.csb.samplefullstack.controller;

import com.csb.samplefullstack.entity.Employee;
import com.csb.samplefullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// RUN THIS CODE
@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //READ in CRUD
    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    //CREATE in CRUD
    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //UPDATE
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }
    @PutMapping("/employees/{id}")
    public Employee putEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //DELETE
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
