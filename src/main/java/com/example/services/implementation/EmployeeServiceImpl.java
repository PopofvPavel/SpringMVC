package com.example.services.implementation;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeByFullName(String fullName) {
        try {
            return employeeRepository.getEmployeeByFullName(fullName);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteEmployeeByFullName(String fullName) {
        Employee employee = getEmployeeByFullName(fullName);
        employeeRepository.deleteEmployee(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployeeList();
    }
}
