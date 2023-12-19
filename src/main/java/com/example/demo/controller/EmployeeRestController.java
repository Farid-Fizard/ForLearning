package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees/api")
public class EmployeeRestController {
    final private EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @ResponseBody
    @GetMapping("/")
    private List<Employee> employees(){
        List<Employee> employeeList= employeeRepository.getEmployeeList();
        return employeeList;
    }
    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable(name="id") long id){
        Optional<Employee> employeeOptional=employeeRepository.getEmployeeById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("We can't find the employee with the %s id",id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee){
        employee=employeeRepository.add(employee);
        return employee;
    }
    @PutMapping("/{id}")
    public Employee putEmployee( @PathVariable(name = "id") long id, @RequestBody Employee employee){
      Optional<Employee> employeeOptional = employeeRepository.getEmployeeById(id);
      if(employeeOptional.isPresent()){
          Employee employeeFromDB= employeeOptional.get();
          employeeFromDB.setName(employee.getName());
          employeeFromDB.setSurname(employee.getSurname());
          employeeFromDB.setSalary(employee.getSalary());
          employeeFromDB= employeeRepository.update(employeeFromDB);
          return employeeFromDB;
      }
      else {
          employee= employeeRepository.add(employee);
          return employee;
      }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteEmployee (@PathVariable(name = "id") long id) {
        Optional<Employee> employeeOptional = employeeRepository.getEmployeeById(id);
        if (employeeOptional.isPresent()) {
            employeeRepository.delete(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Employee with %s id is not deleted",id));
        }
    }
}
