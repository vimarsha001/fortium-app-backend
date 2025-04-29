package edu.icet.ecom.repository.custom.impl;

import java.util.List;
public interface CrudRepository <T,ID> extends SuperDao {
    void addEmployee(T entity);
    void updateEmployee(T entity,Integer id);
    T searchEmployeeById(Integer id);
    List<T> searchEmployeeByName(String name);
    void deleteEmployee(T entity);
    List<T> getAll();
}
