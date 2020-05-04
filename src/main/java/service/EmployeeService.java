package service;

import model.Employee;

import java.util.List;

public interface EmployeeService extends Service<Employee> {
    List<Employee> listAllEmployeesByDepartment(Long departmentId);
}
