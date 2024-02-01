package fr.EmiliePaniagua.poec.exam.repository;

import java.util.List;

public interface SortByNameInterface<T> {

    List<T> findAllByOrderByNameAsc();

}
