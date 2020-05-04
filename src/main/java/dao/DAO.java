package dao;

import model.Department;

import java.sql.SQLIntegrityConstraintViolationException;

public interface DAO<T> {
    boolean insertUpdate(T model);
    boolean delete(Long id);
    T get(Long id);
}
