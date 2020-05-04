package util;

import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.DepartmentDAOImpl;
import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.EmployeeDAOImpl;
import model.Department;
import model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

import java.util.List;

public class EmployeeDuplicateCheck implements CheckWithCheck.SimpleCheck {
    @Override
    public boolean isSatisfied(Object validatedObject, Object o1) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.listAllEmployees();
        Employee validatedEmployee = (Employee) validatedObject;
        for (Employee employee: employees) {
            if (employee.equals(validatedEmployee)){
                return false;
            }
        }
        return true;
    }
}
