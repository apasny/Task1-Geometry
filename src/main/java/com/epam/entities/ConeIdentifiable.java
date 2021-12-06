package com.epam.entities;

import com.epam.data.Observable;
import com.epam.data.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConeIdentifiable extends Cone implements Observable {

    private final int id;
    private final List<Observer> observers = new ArrayList<>();

    public ConeIdentifiable(int id, BaseCenter baseCenter, double radius, Apex apex) {
        super(baseCenter, radius, apex);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setBaseCenter(BaseCenter baseCenter) {
        super.setBaseCenter(baseCenter);
        notifyObserver();
    }

    @Override
    public void setApex(Apex apex) {
        super.setApex(apex);
        notifyObserver();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer:observers) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConeIdentifiable that = (ConeIdentifiable) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
