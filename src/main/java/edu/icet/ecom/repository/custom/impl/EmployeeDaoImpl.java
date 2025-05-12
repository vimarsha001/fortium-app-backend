package edu.icet.ecom.repository.custom.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.custom.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean addEmployee(EmployeeEntity entity) {
        System.out.print(entity);
        String SQL = "INSERT INTO employees (id, name, phone, email, dep, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getName());
            preparedStatement.setObject(3, entity.getPhone());
            preparedStatement.setObject(4, entity.getEmail());
            preparedStatement.setObject(5, entity.getDepartment());
            preparedStatement.setObject(6, entity.getCreatedAt());
            preparedStatement.setObject(7, entity.getUpdatedAt());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateEmployee(EmployeeEntity entity, Integer id) {
        String sql = "UPDATE employees SET name = ? ,phone = ? ,email = ? ,department =?,createdAt = ?,updatedAt=?  WHERE id = '" + id + "'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getPhone());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getDepartment());
            preparedStatement.setDate(5, Date.valueOf(entity.getCreatedAt()));
            preparedStatement.setDate(6, Date.valueOf(entity.getUpdatedAt()));
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeEntity searchEmployeeById(Integer id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(resultSet.getInt(1));
                employeeEntity.setName(resultSet.getString(2));
                employeeEntity.setEmail(resultSet.getString(3));
                employeeEntity.setPhone(resultSet.getString(4));
                employeeEntity.setDepartment(resultSet.getString(5));
                employeeEntity.setCreatedAt(resultSet.getString(6));
                employeeEntity.setUpdatedAt(resultSet.getString(7));
                System.out.println(employeeEntity);
                return employeeEntity;
            }else{
                return  null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EmployeeEntity> searchEmployeeByName(String name) {
        String sql = "SELECT * FROM employees WHERE name = '"+name+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<EmployeeEntity> entityList = new ArrayList<>();
            while (resultSet.next()){
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(resultSet.getInt("1"));
                employeeEntity.setName(resultSet.getString("2"));
                employeeEntity.setEmail(resultSet.getString("3"));
                employeeEntity.setDepartment(resultSet.getString("4"));
                employeeEntity.setCreatedAt(resultSet.getString("5"));
                employeeEntity.setUpdatedAt(resultSet.getString("6"));
                entityList.add(employeeEntity);
            }
            return entityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        String sql = "DELETE FROM employees WHERE id = '" + id + "'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute(sql);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EmployeeEntity> getAll() {
        String sql = "SELECT * FROM employees";
        try {
            List<EmployeeEntity> entityList = new ArrayList<>();
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(resultSet.getInt(1));
                employeeEntity.setName(resultSet.getString(2));
                employeeEntity.setPhone(resultSet.getString(3));
                employeeEntity.setEmail(resultSet.getString(4));
                employeeEntity.setDepartment(resultSet.getString(5));
                employeeEntity.setCreatedAt(resultSet.getString(6));
                employeeEntity.setUpdatedAt(resultSet.getString(7));
                entityList.add(employeeEntity);
            }
            return entityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
