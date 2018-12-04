package com.threexp;

public class Car {

    private int id;
    private String brand;
    private String model;
    private int power;
    private int year;
    private int price;

    public Car(int id, String brand, String model, int power, int year, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
