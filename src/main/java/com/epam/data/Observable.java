package com.epam.data;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();

}
