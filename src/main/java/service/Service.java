package service;

import exception.ValidationException;

public interface Service<T> {
    void insertUpdate(T entity) throws ValidationException;

    void delete(Long id);

    T get(Long id);
}