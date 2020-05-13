package actions.departments;

import actions.Action;
import model.Department;
import service.DepartmentService;
import service.DepartmentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepartmentsListAction implements Action {
    private final DepartmentService departmentService;

    public DepartmentsListAction() {
        this.departmentService  = new DepartmentServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> listDepartments  =  departmentService.listAllDepartments();
        request.setAttribute("departments", listDepartments);
        request.getRequestDispatcher("/WEB-INF/jsp/DepartmentList.jsp").forward(request, response);
    }
}
