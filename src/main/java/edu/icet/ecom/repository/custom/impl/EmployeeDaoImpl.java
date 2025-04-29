package edu.icet.ecom.repository.custom.impl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.custom.EmployeeDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(EmployeeEntity entity) {


    }
    @Override
    public void updateEmployee(EmployeeEntity entity, Integer id) {

    }

    @Override
    public EmployeeEntity searchEmployeeById(Integer id) {
        return null;
    }
    @Override
    public List<EmployeeEntity> searchEmployeeByName(String name) {
        return List.of();
    }
    @Override
    public void deleteEmployee(Integer id) {

    }
    @Override
    public List<EmployeeEntity> getAll() {
        return List.of();
    }
}
