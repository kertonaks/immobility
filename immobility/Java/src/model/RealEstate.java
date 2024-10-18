package model;

public abstract class RealEstate {
    protected String address;
    protected double price;

    public RealEstate(String address, double price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayInfo();
}
