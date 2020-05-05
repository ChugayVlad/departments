package dao.employeeDAO;

import dao.ConnectionBuilder;
import model.Department;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String SELECT_ALL_BY_ID = "SELECT * FROM employees WHERE department_id=?";
    private static final String SELECT_ALL = "SELECT * FROM employees";
    private static final String INSERT = "INSERT INTO employees (id, email, recruitment_date, name, salary, department_id) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM employees where id = ?";
    private static final String UPDATE = "UPDATE employees SET email = ?, recruitment_date = ?, name = ?, salary = ?, department_id = ? WHERE id = ?";
    private static final String GET = "SELECT * FROM employees WHERE id = ?";

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getInstance().getConnection();
    }

    @Override
    public boolean insertUpdate(Employee employee) {
        boolean rowInserted = false;
        String sql = employee.getId() == null ? INSERT : UPDATE;
        try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(sql)) {
            if(UPDATE.equals(sql)){
                statement.setLong(6, employee.getId());
            }
            statement.setString(1, employee.getEmail());
            statement.setObject(2, employee.getRecruitmentDate());
            statement.setString(3, employee.getName());
            statement.setDouble(4, employee.getSalary());
           // statement.setLong(5, employee.getDepartmentId());
            rowInserted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    @Override
    public List<Employee> listAllEmployeesByDepartment(Long departmentId) {
        List<Employee> listEmployees = new ArrayList<>();
        /*try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_BY_ID)) {
            stmt.setLong(1, departmentId);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    listEmployees.add(new Employee(rs.getLong("id"), rs.getString("email"), rs.getDate("recruitment_date"), rs.getString("name"), rs.getDouble("salary"), rs.getLong("department_id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return listEmployees;
    }

    @Override
    public List<Employee> listAllEmployees() {
        List<Employee> listEmployees = new ArrayList<>();
        /*try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Employee employee = new Employee(rs.getLong("id"), rs.getString("email"), rs.getDate("recruitment_date"), rs.getString("name"), rs.getDouble("salary"), rs.getLong("department_id"));
                listEmployees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return listEmployees;
    }

    @Override
    public boolean delete(Long id) {
        boolean rowDeleted = false;
        try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Employee get(Long id){
        Employee employee = null;
        /*try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(GET)) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee(id, resultSet.getString("email"), resultSet.getDate("recruitment_date"), resultSet.getString("name"), resultSet.getDouble("salary"), resultSet.getLong("department_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return employee;
    }

}
