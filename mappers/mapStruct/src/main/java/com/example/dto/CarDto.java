package com.example.dto;

public class CarDto {

    private String manufacturer;
    private int seatCount;
    private String color;

    public CarDto(String manufacturer, int seatCount, String color) {
        this.manufacturer = manufacturer;
        this.seatCount = seatCount;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
