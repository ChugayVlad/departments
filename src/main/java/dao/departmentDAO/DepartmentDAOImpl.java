package dao.departmentDAO;

import model.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public void insertUpdate(Department department) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(department);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Department> listAllDepartments() {
        List<Department> departments = (List<Department>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Department order by id").list();
        return departments;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Department.class, id));
        transaction.commit();
        session.close();
    }

    @Override
    public Department get(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Department.class, id);
    }
}
