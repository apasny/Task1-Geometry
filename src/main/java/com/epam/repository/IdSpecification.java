package com.epam.repository;

import com.epam.entities.ConeIdentifiable;
import java.util.UUID;

public class IdSpecification implements Specification {

    private final UUID id;

    public IdSpecification(UUID id) {
        this.id = id;
    }

    @Override
    public boolean specified(ConeIdentifiable cone) {
        return cone.getId() == id;
    }
}
