package academy.learnprogramming.inheritanceChallenge;

public class Vehicle {

    private String manufacturer;
    private String model;
    private String yearOfManufacturing;

    public Vehicle(String manufacturer, String model, String yearOfManufacturing) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfManufacturing = yearOfManufacturing;
    }

    //region getters & setters
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(String yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }
    //endregion
}
