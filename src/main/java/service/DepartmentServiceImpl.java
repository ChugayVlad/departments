package service;

import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.DepartmentDAOImpl;
import exception.ValidationException;
import model.Department;
import util.ObjectValidator;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO;

    public DepartmentServiceImpl() {
        this.departmentDAO = new DepartmentDAOImpl();
    }

    @Override
    public void insertUpdate(Department department) throws ValidationException {
        ObjectValidator objectValidator = new ObjectValidator();
        objectValidator.validateObject(department);
        departmentDAO.insertUpdate(department);
    }

    @Override
    public List<Department> listAllDepartments() {
        return departmentDAO.listAllDepartments();
    }

    @Override
    public void delete(Long id) {
        departmentDAO.delete(id);
    }

    @Override
    public Department get(Long id) {
        return departmentDAO.get(id);
    }
}
