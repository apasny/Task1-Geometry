package com.epam.data;

import com.epam.entities.ConeIdentifiable;

public interface Observer {

    void update(ConeIdentifiable cone);

}
