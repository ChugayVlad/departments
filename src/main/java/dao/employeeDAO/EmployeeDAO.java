package dao.employeeDAO;

import dao.DAO;
import model.Employee;

import java.util.List;

public interface EmployeeDAO extends DAO<Employee> {
    List<Employee> listAllEmployeesByDepartment(Long departmentId);

    List<Employee> listAllEmployees();
}
