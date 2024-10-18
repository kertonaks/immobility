package model;

public class Garage extends RealEstate {
    private boolean hasElectricity;

    public Garage(String address, double price, boolean hasElectricity) {
        super(address, price);
        this.hasElectricity = hasElectricity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Garage at " + address + ", price: " + price + ", electricity: " + hasElectricity);
    }
}
