package edu.icet.ecom.repository;

import java.util.List;
public interface CrudRepository <T,ID> extends SuperDao {
    void addEmployee(T entity);
    void updateEmployee(T entity,Integer id);
    T searchEmployeeById(Integer id);
    List<T> searchEmployeeByName(String name);
    void deleteEmployee(Integer id);
    List<T> getAll();
}
