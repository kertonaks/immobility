package model;

public class House extends RealEstate {
    private final double landArea;

    public House(String address, double price, double landArea) {
        super(address, price);
        this.landArea = landArea;
    }

    @Override
    public void displayInfo() {
        System.out.println("House at " + address + ", price: " + price + ", land area: " + landArea + " sqm");
    }
}
