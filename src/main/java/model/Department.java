package model;


import net.sf.oval.constraint.*;
import util.DepartmentDuplicateCheck;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="departments")
public class Department{
    private Long id;

    @CheckWith(value = DepartmentDuplicateCheck.class, message = "Department with such name already exists")
    @Length(min = 4, max = 20, message = "Name should be more then 3 characters and less then 20")
    @NotNull (message = "Enter name")
    @NotEmpty(message = "Enter name")
    private String name;

    private List<Employee> employees;

    public Department(){
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
         return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        if(Objects.equals(id, that.id)){
            return false;
        }
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
