package dao.departmentDAO;

import dao.ConnectionBuilder;
import model.Department;
import util.HibernateSessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    private static final String SELECT_ALL = "SELECT * FROM departments ORDER BY id";
    private static final String INSERT = "INSERT INTO departments (id, name) VALUES (DEFAULT, ?)";
    private static final String DELETE = "DELETE FROM departments where id = ?";
    private static final String UPDATE = "UPDATE departments SET name = ? WHERE id = ?";
    private static final String GET = "SELECT * FROM departments WHERE id = ?";
    private Connection getConnection() {
        return ConnectionBuilder.getInstance().getConnection();
    }

    @Override
    public boolean insertUpdate(Department department) {
        String sql = department.getId() == null ? INSERT : UPDATE;
        boolean rowInserted = false;
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            if (UPDATE.equals(sql)) {
                statement.setLong(2, department.getId());
            }
            statement.setString(1, department.getName());
            rowInserted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    @Override
    public List<Department> listAllDepartments() {
        /*List<Department> listDepartments = new ArrayList<>();
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Department department = new Department(rs.getLong("id"), rs.getString("name"));
                listDepartments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDepartments;*/

        List<Department> departments = (List<Department>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Department").list();
        return departments;
    }

    @Override
    public boolean delete(Long id) {
        boolean rowDeleted = false;
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Department get(Long id) {
        Department department = null;
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(GET)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    department = new Department(id, resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}
