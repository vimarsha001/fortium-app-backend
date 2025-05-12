package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.service.custom.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all")
    List<Employee> getAll(){
        return employeeService.getAll();
    }
    @PostMapping("/add")
    void addEmployee(@RequestBody Employee employee){
        System.out.print(employee);
        employeeService.addEmployee(employee);
    }
    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }
    @PatchMapping("/update")
    void updateEmployee(@RequestBody Employee employee,@RequestParam Integer id){
        employeeService.updateEmployee(employee,id);
    }
    @GetMapping("/search-name")
    List<Employee> searchEmployeeByName(@RequestParam String name){
       return employeeService.searchEmployeeByName(name);
    }
    @GetMapping("/search/{id}")
    ResponseEntity<Employee> searchEmployeeById(@PathVariable Integer id){
        Employee employee;
        employee = employeeService.searchEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
}
