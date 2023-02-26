package ru.akvine.prorise.validator;

public interface Validator<T> {
    void validate(T obj);
}
