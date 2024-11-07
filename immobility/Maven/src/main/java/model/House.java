package model;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class House extends RealEstate {
    @Column(name = "area")
    private double area;

    @Column(name = "heating_type")
    private String heatingType;

    public House() {}

    public House(String location, double price, double area, String heatingType) {
        super(location, price);
        this.area = area;
        this.heatingType = heatingType;
    }

    // Getters and Setters
}
