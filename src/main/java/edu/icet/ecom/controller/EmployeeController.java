package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.service.custom.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all")
    List<Employee> getAll(){
        return employeeService.getAll();
    }
    void addEmployee(Employee employee){
        employeeService.addEmployee(employee);
    }
    @DeleteMapping("/delete")
    void deleteEmployee(Integer id){
        employeeService.deleteEmployee(id);
    }
    @PatchMapping("/update")
    void updateEmployee(Employee employee,Integer id){
        employeeService.updateEmployee(employee,id);
    }
    @GetMapping("/search")
    List<Employee> searchEmployeeByName(String name){
       return employeeService.searchEmployeeByName(name);
    }
    @GetMapping("/search")
    Employee searchEmployeeById(Integer id){
        return employeeService.searchEmployeeById(id);
    }
}
