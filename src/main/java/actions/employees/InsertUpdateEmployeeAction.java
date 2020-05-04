package actions.employees;

import actions.Action;
import exception.ValidationException;
import model.Employee;

import service.EmployeeServiceImpl;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InsertUpdateEmployeeAction implements Action {
    private Service<Employee> employeeService;

    public InsertUpdateEmployeeAction() {
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();

        String departmentId = request.getParameter("departmentId");
        employee.setEmail(request.getParameter("email"));
        try {
            Date date = Date.valueOf(LocalDate.parse(request.getParameter("recruitmentDate")));
            employee.setRecruitmentDate(date);
        } catch (DateTimeParseException e){
            employee.setRecruitmentDate(null);
        }
        employee.setName(request.getParameter("name"));
        try {
            employee.setSalary(Double.parseDouble(request.getParameter("salary")));
        } catch (NumberFormatException e){
            employee.setSalary(null);
        }
        employee.setDepartmentId(Long.parseLong(departmentId));
        if (request.getParameter("id") != null) {
            employee.setId(Long.parseLong(request.getParameter("id")));
        }
        try {
            employeeService.insertUpdate(employee);
            response.sendRedirect("/departments/employees" + "?departmentId=" + departmentId);
        } catch (ValidationException validationException){
            request.setAttribute("employee", employee);
            request.setAttribute("departmentId", request.getParameter("departmentId"));
            request.setAttribute("map", validationException.getValidationMap());
            request.getRequestDispatcher("/WEB-INF/jsp/InsertUpdateEmployee.jsp").forward(request, response);
        }
    }
}