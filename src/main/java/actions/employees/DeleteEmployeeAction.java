package actions.employees;

import actions.Action;
import model.Employee;
import service.EmployeeServiceImpl;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployeeAction implements Action {
    private Service<Employee> employeeService;

    public DeleteEmployeeAction() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setId(Long.parseLong(request.getParameter("id")));
        employeeService.delete(employee);
        String departmentId = request.getParameter("departmentId");
        response.sendRedirect("/departments/employees" + "?departmentId=" + departmentId);
    }
}
