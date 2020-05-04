package model;


import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import util.DepartmentDuplicateCheck;

import java.io.Serializable;
import java.util.Objects;


public class Department implements Serializable {
    private static final long serialVersionUID = -8802442547635617217L;

    private Long id;

    @CheckWith(value = DepartmentDuplicateCheck.class, message = "Department with such name already exists")
    @NotNull (message = "Enter name")
    @NotEmpty(message = "Enter name")
    @Length(min = 4, max = 20, message = "Name should be more then 3 characters and less then 20")
    private String name;

    public Department(){
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
         return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
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
