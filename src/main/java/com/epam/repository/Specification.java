package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

public interface Specification {

    boolean specified(ConeIdentifiable cone);

}
