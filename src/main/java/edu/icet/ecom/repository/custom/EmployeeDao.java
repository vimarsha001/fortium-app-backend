package edu.icet.ecom.repository.custom;

import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeEntity,Integer> {
    boolean addEmployee(EmployeeEntity entity);
    boolean updateEmployee(EmployeeEntity entity,Integer id);
    EmployeeEntity searchEmployeeById(Integer id);
    List<EmployeeEntity> searchEmployeeByName(String name);
    boolean deleteEmployee(Integer id);
    List<EmployeeEntity> getAll();
}
