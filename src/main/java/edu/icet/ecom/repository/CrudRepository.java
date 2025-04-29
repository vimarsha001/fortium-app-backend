package edu.icet.ecom.repository;

import java.util.List;
public interface CrudRepository <T,ID> extends SuperDao {
    boolean addEmployee(T entity);
    boolean updateEmployee(T entity,Integer id);
    T searchEmployeeById(Integer id);
    List<T> searchEmployeeByName(String name);
    boolean deleteEmployee(Integer id);
    List<T> getAll();
}
