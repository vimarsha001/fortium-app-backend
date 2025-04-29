package edu.icet.ecom.repository.custom.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.custom.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private EmployeeEntity employeeEntity;
    @Override
    public boolean addEmployee(EmployeeEntity entity) {
        String SQL = "INSERT INTO employees VALUES(?,?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2,entity.getName());
            preparedStatement.setObject(3,entity.getEmail());
            preparedStatement.setObject(4,entity.getDepartment());
            preparedStatement.setObject(5,entity.getCreatedAt());
            preparedStatement.setObject(6,entity.getUpdatedAt());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public boolean updateEmployee(EmployeeEntity entity, Integer id) {
        String sql = "UPDATE employees SET name = ? ,email = ? ,department =?,createdAt = ?,updatedAt=?  WHERE id = '"+id+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity);
            preparedStatement.setInt(3, employeeId);

            // Return true if at least one row was updated
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    public boolean deleteEmployee(Integer id) {
        String sql = "DELETE FROM employees WHERE id = '"+id+"'";
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
            while(resultSet.next()){
                employeeEntity.setId(resultSet.getInt("1"));
                employeeEntity.setName(resultSet.getString("2"));
                employeeEntity.setEmail(resultSet.getString("3"));
                employeeEntity.setDepartment(resultSet.getString("4"));
                employeeEntity.setCreatedAt(resultSet.getDate("5").toLocalDate());
                employeeEntity.setUpdatedAt(resultSet.getDate("6").toLocalDate());
                entityList.add(employeeEntity);
            }
            return entityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
