package com.threexp

import spock.lang.Specification

class UtilsTest extends Specification {

    def "should return 0 as first available id when list is empty"() {
        given:
        List<Car> cars = []

        when:
        int id = Utils.findFirstAvailableId(cars)

        then:
        id == 0
    }

    def "should return 0 as first available id when list is one element long and the id is 1"() {
        given:
        List<Car> cars = [new Car(1, "brand1", "model1", 231, 2005, 23000)]

        when:
        int id = Utils.findFirstAvailableId(cars)

        then:
        id == 0
    }

    def "should return 0 as first available id when list is one element long and the id is 2"() {
        given:
        List<Car> cars = [new Car(2, "brand1", "model1", 231, 2005, 23000)]

        when:
        int id = Utils.findFirstAvailableId(cars)

        then:
        id == 0
    }

    def "should return 4 as first available id when list is coherent and 4 element long"() {
        given:
        List<Car> cars = [
                new Car(0, "brand1", "model1", 231, 2005, 23000),
                new Car(1, "brand2", "model2", 131, 2001, 13000),
                new Car(2, "brand3", "model3", 211, 2003, 34050),
                new Car(3, "brand4", "model4", 71, 2015, 55050),
        ]

        when:
        int id = Utils.findFirstAvailableId(cars)

        then:
        id == 4
    }

    def "should return 0 as first available id when list has no first element"() {
        given:
        List<Car> cars = [
                new Car(1, "brand2", "model2", 131, 2001, 13000),
                new Car(2, "brand3", "model3", 211, 2003, 34050),
                new Car(3, "brand4", "model4", 71, 2015, 55050),
        ]

        when:
        int id = Utils.findFirstAvailableId(cars)

        then:
        id == 0
    }

    def "should return 3 as first available id when there is a gap on 4th position"() {
        given:
        List<Car> cars = [
                new Car(0, "brand1", "model1", 231, 2005, 23000),
                new Car(1, "brand2", "model2", 131, 2001, 13000),
                new Car(2, "brand3", "model3", 211, 2003, 34050),
                new Car(4, "brand5", "model5", 171, 2005, 51050),
        ]

        when:
        int id = Utils.findFirstAvailableId(cars)

        then:
        id == 3
    }
}
