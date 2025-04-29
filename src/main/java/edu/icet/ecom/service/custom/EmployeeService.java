package edu.icet.ecom.service.custom;

import edu.icet.ecom.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(Integer id);
    void updateEmployee(Employee employee,Integer id);
    List<Employee> searchEmployeeByName(String name);
    Employee searchEmployeeById(Integer id);
    List<Employee> getAll();
}
