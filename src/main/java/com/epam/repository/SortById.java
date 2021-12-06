package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

import java.util.Comparator;

public class SortById implements Comparator<ConeIdentifiable> {

    @Override
    public int compare(ConeIdentifiable o1, ConeIdentifiable o2) {
        return o1.getId()-o2.getId();
    }
}
