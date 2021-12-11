package com.epam.observer;

import com.epam.entities.ConeIdentifiable;
import com.epam.entities.Parameters;
import com.epam.logic.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class ConeStorage implements Observer {

    private static ConeStorage instance;

    private final Calculator calculator = new Calculator();

    private final Map<UUID, Parameters> calculatedVolumeAndArea = new HashMap<>();

    private ConeStorage() {
    }

    public Map<UUID, Parameters> getCalculatedVolumeAndArea() {
        return calculatedVolumeAndArea;
    }

    @Override
    public void update(ConeIdentifiable cone){
        double volume = calculator.calculateVolume(cone);
        double area = calculator.calculateArea(cone);
        calculatedVolumeAndArea.put(cone.getId(),new Parameters(volume,area));
    }

    public static ConeStorage getInstance() {
        if(instance == null) {
            instance = new ConeStorage();
        }
        return instance;
    }

}
