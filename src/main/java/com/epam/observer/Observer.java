package com.epam.observer;

import com.epam.entities.ConeIdentifiable;

public interface Observer {

    void update(ConeIdentifiable cone);

}
