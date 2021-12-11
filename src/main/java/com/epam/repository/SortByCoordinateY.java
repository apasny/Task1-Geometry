package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

import java.util.Comparator;

public class SortByCoordinateY implements Comparator<ConeIdentifiable> {

    @Override
    public int compare(ConeIdentifiable cone1, ConeIdentifiable cone2) {
        return (int) (cone1.getBaseCenter().getY() - cone2.getBaseCenter().getY());
    }

}
