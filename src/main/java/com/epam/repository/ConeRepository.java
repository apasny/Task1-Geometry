package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

import java.util.Comparator;
import java.util.List;

public interface ConeRepository{

    void add(ConeIdentifiable cone);
    void remove(ConeIdentifiable cone);
    void update(ConeIdentifiable cone);

    List<ConeIdentifiable> query(Specification specification);

    List<ConeIdentifiable> sort(Comparator<ConeIdentifiable> comparator);
}
