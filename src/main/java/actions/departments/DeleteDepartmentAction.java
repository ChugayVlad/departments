package actions.departments;

import actions.Action;
import model.Department;
import service.Service;
import service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDepartmentAction implements Action {
    private Service<Department> departmentService;

    public DeleteDepartmentAction() {
        this.departmentService = new DepartmentServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        departmentService.delete(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/departments/departments");
    }
}
