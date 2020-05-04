package actions.departments;

import actions.Action;
import exception.ValidationException;
import model.Department;
import net.sf.oval.exception.ValidationFailedException;
import service.Service;
import service.DepartmentServiceImpl;
import util.ObjectValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InsertUpdateDepartmentAction implements Action {
    private Service<Department> departmentService;

    public InsertUpdateDepartmentAction() {
        this.departmentService = new DepartmentServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();

        department.setName(request.getParameter("name"));
        if ((request.getParameter("id") != null)) {
            department.setId(Long.parseLong(request.getParameter("id")));
        }
        try {
            departmentService.insertUpdate(department);
            response.sendRedirect("/departments/departments");
        } catch (ValidationException validationException){
            request.setAttribute("department", department);
            request.setAttribute("map", validationException.getValidationMap());
            request.getRequestDispatcher("/WEB-INF/jsp/InsertUpdateDepartment.jsp").forward(request, response);
        }
    }
}
