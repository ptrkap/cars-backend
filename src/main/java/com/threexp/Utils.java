package com.threexp;

import java.util.Comparator;
import java.util.List;

public class Utils {

    public static int findFirstAvailableId(List<Car> cars) {
        cars.sort(Comparator.comparingInt(Car::getId));
        int n = cars.size();
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            if (cars.get(0).getId() > 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (cars.get(0).getId() > 0) {
                return 0;
            }
            for (int i = 1; i < n; i++) {
                if (cars.get(i).getId() - cars.get(i-1).getId() > 1) {
                    return cars.get(i-1).getId() + 1;
                }
            }
            return cars.get(n-1).getId() + 1;
        }
    }
}
