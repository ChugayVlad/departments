package service;

import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.EmployeeDAOImpl;
import exception.ValidationException;
import model.Employee;
import util.ObjectValidator;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void insertUpdate(Employee employee) throws ValidationException {
        ObjectValidator objectValidator = new ObjectValidator();
        objectValidator.validateObject(employee);
        employeeDAO.insertUpdate(employee);
    }

    @Override
    public List<Employee> listAllEmployeesByDepartment(Long departmentId) {
        return employeeDAO.listAllEmployeesByDepartment(departmentId);
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }

    @Override
    public Employee get(Long id)  {
        return employeeDAO.get(id);
    }

}
