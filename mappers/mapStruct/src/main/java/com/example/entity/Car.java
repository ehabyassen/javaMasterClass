package com.example.entity;

public class Car {

    private String make;
    private int numberOfSeats;
    private String color;
    private int speed;

    public Car(String make, int numberOfSeats, String color, int speed) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.color = color;
        this.speed = speed;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
