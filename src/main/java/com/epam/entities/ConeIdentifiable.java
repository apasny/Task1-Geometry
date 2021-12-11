package com.epam.entities;

import com.epam.observer.Observable;
import com.epam.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ConeIdentifiable extends Cone implements Observable {

    private final UUID id;
    private final List<Observer> observers = new ArrayList<>();

    public ConeIdentifiable(UUID id, Cone cone) {
        super(cone.getBaseCenter(), cone.getRadius(), cone.getApex());
        this.id = id;
    }

    public UUID getId() {
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
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "ConeIdentifiable{" +
                "id=" + id +
                '}';
    }
}
