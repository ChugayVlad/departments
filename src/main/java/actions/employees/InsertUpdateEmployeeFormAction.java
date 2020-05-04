package actions.employees;

import actions.Action;
import model.Employee;
import service.EmployeeServiceImpl;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertUpdateEmployeeFormAction implements Action {
    private Service<Employee> employeeService;

    public InsertUpdateEmployeeFormAction() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null){
            Long id = Long.parseLong(request.getParameter("id"));
            request.setAttribute("employee", employeeService.get(id));
        }
        request.setAttribute("departmentId", request.getParameter("departmentId"));
        request.getRequestDispatcher("/WEB-INF/jsp/InsertUpdateEmployee.jsp").forward(request, response);
    }
}
