package dao;

import model.Department;

import java.sql.SQLIntegrityConstraintViolationException;

public interface DAO<T> {
    void insertUpdate(T entity);
    void delete(T entity);
    T get(Long id);
}
