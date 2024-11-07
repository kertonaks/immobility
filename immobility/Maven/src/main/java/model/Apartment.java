package model;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment extends RealEstate {
    @Column(name = "rooms")
    private int rooms;

    public Apartment() {}

    public Apartment(String location, double price, int rooms) {
        super(location, price);
        this.rooms = rooms;
    }

    // Getters and Setters
}
