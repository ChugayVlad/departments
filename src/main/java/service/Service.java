package service;

import exception.ValidationException;

public interface Service<T> {
    void insertUpdate(T entity) throws ValidationException;

    void delete(T entity);

    T get(Long id);
}