package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

import java.util.Comparator;

public class SortById implements Comparator<ConeIdentifiable> {

    @Override
    public int compare(ConeIdentifiable cone1, ConeIdentifiable cone2) {
        return cone1.getId()-cone2.getId();
    }

}
