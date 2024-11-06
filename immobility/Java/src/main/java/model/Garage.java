package model;

public class Garage extends RealEstate {
    private boolean hasElectricity;

    public Garage(int id, String location, double price, boolean hasElectricity) {
        super(id, location, price);
        this.hasElectricity = hasElectricity;
    }

    public boolean isHasElectricity() {
        return hasElectricity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Garage ID: " + getId() + ", Location: " + getLocation() + ", Price: " + getPrice() + ", Has Electricity: " + hasElectricity);
    }
}
