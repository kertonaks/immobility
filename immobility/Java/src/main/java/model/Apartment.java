package model;

public class Apartment extends RealEstate {
    private int rooms;

    public Apartment(int id, String location, double price, int rooms) {
        super(id, location, price);
        this.rooms = rooms;
    }

    public int getRooms() {
        return rooms;
    }

    @Override
    public void displayInfo() {
        System.out.println("Apartment ID: " + getId() + ", Location: " + getLocation() + ", Price: " + getPrice() + ", Rooms: " + rooms);
    }
}
