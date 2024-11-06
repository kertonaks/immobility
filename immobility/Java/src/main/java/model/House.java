package model;

public class House extends RealEstate {
    private double area;

    public House(int id, String location, double price, double area) {
        super(id, location, price);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public void displayInfo() {
        System.out.println("House ID: " + getId() + ", Location: " + getLocation() + ", Price: " + getPrice() + ", Area: " + area);
    }
}
