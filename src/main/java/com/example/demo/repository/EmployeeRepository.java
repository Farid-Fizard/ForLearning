package com.example.demo.repository;

import com.example.demo.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getEmployeeList();
    Optional<Employee> getEmployeeById(long id);

    Optional<Employee> getEmployeeByName(String name);
    Employee  add(Employee employee);

    Employee update(Employee employee);
    boolean delete(long id);

}
