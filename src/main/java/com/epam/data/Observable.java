package com.epam.data;

import java.util.List;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();

}
