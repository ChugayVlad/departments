package actions.departments;

import actions.Action;
import model.Department;
import service.Service;
import service.DepartmentServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertUpdateDepartmentFormAction implements Action {
    private Service<Department> departmentService;

    public InsertUpdateDepartmentFormAction() {
        this.departmentService = new DepartmentServiceImpl();;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null){
            Long id = Long.parseLong(request.getParameter("id"));
            request.setAttribute("department", departmentService.get(id));
        }
        request.getRequestDispatcher("/WEB-INF/jsp/InsertUpdateDepartment.jsp").forward(request, response);
    }
}
