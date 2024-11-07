package model;

import javax.persistence.*;

@Entity
@Table(name = "garages")
public class Garage extends RealEstate {
    @Column(name = "has_electricity")
    private boolean hasElectricity;

    public Garage() {}

    public Garage(String location, double price, boolean hasElectricity) {
        super(location, price);
        this.hasElectricity = hasElectricity;
    }

    // Getters and Setters
}
