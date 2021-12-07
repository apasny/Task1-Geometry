package com.epam.repository;

import com.epam.entities.ConeIdentifiable;

import java.util.*;

public class ConeRepositoryImpl implements ConeRepository {

    private final Map<Integer, ConeIdentifiable> store = new HashMap<>();

    @Override
    public void add(ConeIdentifiable cone) {
        store.putIfAbsent(cone.getId(), cone);
    }

    @Override
    public void remove(ConeIdentifiable cone) {
        store.remove(cone.getId());
    }

    @Override
    public void update(ConeIdentifiable cone) {
        store.replace(cone.getId(), store.get(cone.getId()), cone);
    }

    @Override
    public List<ConeIdentifiable> query(Specification specification) {
        List<ConeIdentifiable> cones = new ArrayList<>();
        for (ConeIdentifiable cone : store.values()) {
            if (specification.specified(cone)) {
                cones.add(cone);
            }
        }
        return cones;
    }

    @Override
    public List<ConeIdentifiable> sort(Comparator<ConeIdentifiable> comparator) {

        List<ConeIdentifiable> cones = new ArrayList<>(store.values());

        cones.sort(comparator);

        return cones;
    }

}
