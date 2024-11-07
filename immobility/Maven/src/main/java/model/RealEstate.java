package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "real_estates")
public abstract class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private double price;

    public RealEstate() {}

    public RealEstate(String location, double price) {
        this.location = location;
        this.price = price;
    }

    // Getters and Setters
}
