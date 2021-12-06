package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

public class IdSpecification implements Specification {

    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(ConeIdentifiable cone) {
        return cone.getId() == id;
    }
}
