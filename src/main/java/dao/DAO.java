package dao;

import model.Department;

import java.sql.SQLIntegrityConstraintViolationException;

public interface DAO<T> {
    void insertUpdate(T entity);
    void delete(Long id);
    T get(Long id);
}
