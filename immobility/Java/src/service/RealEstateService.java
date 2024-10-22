package service;

import model.House;

import model.Garage;
import model.Apartment;


import model.RealEstate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RealEstateService {
    private static final List<RealEstate> realEstateList = new ArrayList<>();
    static {
     realEstateList.add(new House("Chernivtsi", 10.00, 20.00));
     realEstateList.add(new Apartment("Chernivtsi", 200.00, 2));
     realEstateList.add(new Apartment("Chernivtsi", 300.00, 5));
     realEstateList.add(new Garage("Chernivtsi", 1.00, false));

    }

    // Існуючі методи додавання, видалення тощо

    public void sortByPrice() {
        realEstateList.sort(Comparator.comparing(RealEstate::getPrice));
        System.out.println("Sorted by Price:");
        for (RealEstate estate : realEstateList) {
            estate.displayInfo();
        }
    }
    // Сортування апартаментів за ціною
    public void sortApartmentsByPrice() {
        // Фільтруємо апартаменти та сортуємо їх за ціною
        List<Apartment> sortedApartments = realEstateList.stream()
                .filter(Apartment.class::isInstance)
                .map(Apartment.class::cast)
                .sorted((a1, a2) -> Double.compare(a1.getPrice(), a2.getPrice()))
                .toList();

        System.out.println("Sorted Apartments by Price:");
        for (Apartment apartment : sortedApartments) {
            apartment.displayInfo();
        }
    }
    // Сортування будинків за ціною
    public void sortHousesByPrice() {
        List<House> sortedHouses = realEstateList.stream()
                .filter(House.class::isInstance)
                .map(House.class::cast)
                .sorted((h1, h2) -> Double.compare(h1.getPrice(), h2.getPrice()))
                .toList();

        System.out.println("Sorted Houses by Price:");
        for (House house : sortedHouses) {
            house.displayInfo();
        }
    }

    // Сортування гаражів за ціною
    public void sortGaragesByPrice() {
        List<Garage> sortedGarages = realEstateList.stream()
                .filter(Garage.class::isInstance)
                .map(Garage.class::cast)
                .sorted((g1, g2) -> Double.compare(g1.getPrice(), g2.getPrice()))
                .toList();

        System.out.println("Sorted Garages by Price:");
        for (Garage garage : sortedGarages) {
            garage.displayInfo();
        }
    }
}
