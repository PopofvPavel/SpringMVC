package com.example.services;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Employee getEmployeeByFullName(String fullName);

    void deleteEmployeeByFullName(String fullName);

    List<Employee> getEmployees();
}
