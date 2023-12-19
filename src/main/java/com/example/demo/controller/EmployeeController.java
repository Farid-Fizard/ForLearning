package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    final private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public ModelAndView viewEmployees(){
        ModelAndView mav= new ModelAndView("employees");
        List<Employee>employees= employeeRepository.getEmployeeList();
        mav.addObject("employees",employees);
        return mav;
    }
    @GetMapping("/{id}")
    public ModelAndView viewEmployeeDetails(@PathVariable(name = "id") long employeeId){
        ModelAndView mav=new ModelAndView("employee");
        Optional<Employee> employeeOptional= employeeRepository.getEmployeeById(employeeId);
        employeeOptional.ifPresent(employee -> mav.addObject("employee", employee));
        return mav;
    };

    //Ambigious handler methods mapped  problemi eyni anda iki eyni yola malik get sorgusu...

    @GetMapping("/name/{name}")
    public ModelAndView viewEmployeeByName(@PathVariable(name = "name") String employeeName){
        ModelAndView mav= new ModelAndView("employee2");
        Optional<Employee> employeeOptional= employeeRepository.getEmployeeByName(employeeName);
        employeeOptional.ifPresent(employee -> mav.addObject("employee2", employee));
        return mav;
    }

    @GetMapping("/add")
    public String add(){
        return "add-employee";
    }
    @PostMapping("/add")
    public String addEmployee(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("salary")BigDecimal salary
            ){
        Employee employee= new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setSalary(salary);
        employee=employeeRepository.add(employee);
        return "redirect:/employees/";
    }
}
