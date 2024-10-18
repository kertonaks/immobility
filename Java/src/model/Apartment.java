package model;

public class Apartment extends RealEstate {
    private int rooms;

    public Apartment(String address, double price, int rooms) {
        super(address, price);
        this.rooms = rooms;
    }

    @Override
    public void displayInfo() {
        System.out.println("Apartment at " + address + ", price: " + price + ", rooms: " + rooms);
    }
}
