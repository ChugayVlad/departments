package actions.employees;

import actions.Action;
import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeesListAction implements Action {
    private final EmployeeService employeeService;

    public EmployeesListAction() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("departmentId");
        List<Employee> employees =  employeeService.listAllEmployeesByDepartment(Long.parseLong(departmentId));
        request.setAttribute("employees", employees);
        request.setAttribute("departmentId", departmentId);
        request.getRequestDispatcher("/WEB-INF/jsp/EmployeesList.jsp").forward(request, response);
    }
}
