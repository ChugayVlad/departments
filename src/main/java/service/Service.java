package service;

import exception.ValidationException;

public interface Service<T> {
    boolean insertUpdate(T model) throws ValidationException;

    boolean delete(Long id);

    T get(Long id);
}