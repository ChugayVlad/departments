package model;

import net.sf.oval.constraint.*;
import util.EmployeeDuplicateCheck;


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class Employee implements Serializable {
    private static final long serialVersionUID = 7371941336836653874L;

    private Long id;

    @CheckWith(value = EmployeeDuplicateCheck.class, message = "Employee with such email already exists")
    @Email(message = "Wrong email format")
    @NotNull (message = "Enter email")
    @NotEmpty(message = "Enter email")
    private String email;

    @DateRange(max = "today", message = "Future date is not allowed")
    @NotNull (message = "Enter recruitment date")
    @NotEmpty(message = "Enter recruitment date")
    private Date recruitmentDate;

    @Length(min = 4, max = 20, message = "Name should be more then 3 characters and less then 20")
    @NotNull (message = "Enter name")
    @NotEmpty(message = "Enter name")
    private String name;

    @NotNull(message = "Enter salary")
    @NotEmpty(message = "Enter salary")
    @Min(value = 0, message = "Salary should be > 0")
    private Double salary;

    private Long departmentId;

    public Employee(){
    }

    public Employee(Long id, String email, Date recruitmentDate, String name, Double salary, Long departmentId) {
        this.id = id;
        this.email = email;
        this.recruitmentDate = recruitmentDate;
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(Date recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if( Objects.equals(id, employee.id)){
            return false;
        }
        return Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, recruitmentDate, name, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", recruitmentDate=" + recruitmentDate +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}
