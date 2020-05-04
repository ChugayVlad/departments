package util;

import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.DepartmentDAOImpl;
import model.Department;
import net.sf.oval.constraint.CheckWithCheck;

import java.util.List;

public class DepartmentDuplicateCheck implements CheckWithCheck.SimpleCheck {
    @Override
    public boolean isSatisfied(Object validatedObject, Object o1) {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        List<Department> departments = departmentDAO.listAllDepartments();
        Department validatedDepartment = (Department) validatedObject;
        for (Department department: departments) {
            if (department.equals(validatedDepartment)){
                return false;
            }
        }
       return true;
    }
}
