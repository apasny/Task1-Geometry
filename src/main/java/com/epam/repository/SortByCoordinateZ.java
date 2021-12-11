package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

import java.util.Comparator;

public class SortByCoordinateZ implements Comparator<ConeIdentifiable> {

    @Override
    public int compare(ConeIdentifiable cone1, ConeIdentifiable cone2) {
        return (int)(cone1.getBaseCenter().getZ() - cone2.getBaseCenter().getZ());
    }

}
