package dao.departmentDAO;

import dao.DAO;
import model.Department;

import java.util.List;

public interface DepartmentDAO extends DAO<Department> {
    List<Department> listAllDepartments();
}
