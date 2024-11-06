package model;

public abstract class RealEstate {
    private int id;
    private String location;
    private double price;

    public RealEstate(int id, String location, double price) {
        this.id = id;
        this.location = location;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayInfo();
}
