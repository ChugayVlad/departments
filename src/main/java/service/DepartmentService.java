package service;

import model.Department;

import java.util.List;

public interface DepartmentService extends Service<Department> {
    List<Department> listAllDepartments();
}
