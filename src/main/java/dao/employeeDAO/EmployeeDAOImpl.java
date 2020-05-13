package dao.employeeDAO;

import model.Department;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;


import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void insertUpdate(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Employee> listAllEmployeesByDepartment(Long departmentId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Department department = new Department(departmentId, null);
        Query query = session.createQuery("FROM Employee E WHERE E.department.id = :departmentId");
        List<Employee> employees =(List<Employee>) query.setParameter("departmentId", departmentId).list();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> listAllEmployees() {
        List<Employee> employees = (List<Employee>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Employee").list();
        return employees;
    }

    @Override
    public void delete(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public Employee get(Long id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Employee.class, id);
    }

}
