package com.threexp;

import java.util.List;

class CarIdAssigner {

    static void assignId(List<Car> cars, Car carToBeAdded) {
        int id = Utils.findFirstAvailableId(cars);
        carToBeAdded.setId(id);
    }
}
