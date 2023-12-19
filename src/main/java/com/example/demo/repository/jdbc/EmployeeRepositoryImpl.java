package com.example.demo.repository.jdbc;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.jdbc.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private JdbcTemplate jdbcTemplate;
    private EmployeeRowMapper employeeRowMapper;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //Autowired nəticəvi konstruktorun yaranmasını təmin edir.
    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate, EmployeeRowMapper employeeRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRowMapper = employeeRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Employee> getEmployeeList() {
        System.out.println();
        String sql = "select id, name, surname, salary" +
                " from  employees " +
                "order by id ";
        List<Employee> employees = jdbcTemplate.query(sql, employeeRowMapper);
        System.out.println(employees);
        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
            Optional<Employee> optionalEmployee= Optional.empty();
        String sql = "select id, name, surname, salary " +
                "from employees " +
                "where id = ?";
        List<Employee> employees = jdbcTemplate.query(sql,new Object[]{id},employeeRowMapper);
        if(!employees.isEmpty()){
            optionalEmployee= Optional.of(employees.get(0));
        }
        return optionalEmployee;
    }
//  sorguya gore cagirmaqin ikinci ve daha duzgun usulu
    @Override
    public Optional<Employee> getEmployeeByName(String name) {
        Optional<Employee> optionalEmployee= Optional.empty();
        String sql="select id, name, surname, salary " +
                "from employees " +
                "where name= :name";
        MapSqlParameterSource params= new MapSqlParameterSource("name",name) ;
        List<Employee>employees= namedParameterJdbcTemplate.query(sql,params,employeeRowMapper);
        if(!employees.isEmpty()){
            optionalEmployee=Optional.of(employees.get(0));
        }
        return optionalEmployee;
    }

    @Transactional
    @Override
    public Employee add(Employee employee) {
        String sql = "INSERT INTO employees (name, surname, salary) VALUES (:ad, :soyad, :maas)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("ad", employee.getName())
                .addValue("soyad", employee.getSurname())
                .addValue("maas", employee.getSalary());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[]{"id"});

        if (count > 0) {
            employee.setId(keyHolder.getKey().longValue());
        }
        return employee;
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        String sql= "update employees " +
                "set name= :name, surname= :surname, salary= :salary " +
                "where  id= :id";
        MapSqlParameterSource params= new MapSqlParameterSource().addValue("name",employee.getName())
                .addValue("surname",employee.getSurname())
                .addValue("salary", employee.getSalary())
                .addValue("id", employee.getId());
        int count = namedParameterJdbcTemplate.update(sql,params);
        if(count==0){
            throw new RuntimeException("Employee not updated"+employee);
        }
        return employee;
    }

    @Override
    public boolean delete(long id) {
        String sql= "delete from employees " +
                "where  id= :id";
        MapSqlParameterSource params= new MapSqlParameterSource("id",id);
        int count = namedParameterJdbcTemplate.update(sql,params);
        return count==1;
    }
}
