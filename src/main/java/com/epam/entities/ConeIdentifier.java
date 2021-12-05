package com.epam.entities;

import com.epam.data.Observable;
import com.epam.data.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConeIdentifier extends Cone implements Observable {

    private final int id;
    private final List<Observer> observers = new ArrayList<>();

    public ConeIdentifier(int id, BaseCenter baseCenter, double radius, Apex apex) {
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
}
