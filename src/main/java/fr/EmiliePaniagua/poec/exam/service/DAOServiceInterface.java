package fr.EmiliePaniagua.poec.exam.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();
    T getObjectById(Long id);
}
