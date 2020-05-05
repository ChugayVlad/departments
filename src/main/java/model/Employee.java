package model;

import net.sf.oval.constraint.*;
import util.EmployeeDuplicateCheck;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

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

    private Department department;

    public Employee(){
    }

    public Employee(Long id, String email, Date recruitmentDate, String name, Double salary) {
        this.id = id;
        this.email = email;
        this.recruitmentDate = recruitmentDate;
        this.name = name;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "recruitment_date")
    public Date getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(Date recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        return Objects.hash(id, email, recruitmentDate, name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", recruitmentDate=" + recruitmentDate +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
