package edu.icet.ecom.service.custom.impl;

import edu.icet.ecom.config.Mapper;
import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.custom.EmployeeDao;
import edu.icet.ecom.service.custom.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeDao employeeDao;
    final ModelMapper mapper;
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(mapper.map(employee,EmployeeEntity.class));
    }
    @Override
    public void deleteEmployee(Integer id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee, Integer id) {
        employeeDao.updateEmployee(mapper.map(employee,EmployeeEntity.class),id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> employeeList = employeeDao.searchEmployeeByName(name);
        for (EmployeeEntity employeeEntity : employeeList) {
            Employee employee = mapper.map(employeeEntity, Employee.class);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee searchEmployeeById(Integer id) {
       return mapper.map(employeeDao.searchEmployeeById(id),Employee.class);
    }
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> employeeList = employeeDao.getAll();
        for (EmployeeEntity employeeEntity : employeeList) {
            Employee employee = mapper.map(employeeEntity, Employee.class);
            employees.add(employee);
        }
        return employees;
    }
}
