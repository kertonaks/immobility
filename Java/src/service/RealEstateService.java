package service;

import model.RealEstate;

import java.util.Comparator;
import java.util.List;

public class RealEstateService {
    private List<RealEstate> realEstateList;

    // Існуючі методи додавання, видалення тощо

    public void sortByPrice() {
        realEstateList.sort(Comparator.comparing(RealEstate::getPrice));
        System.out.println("Sorted by Price:");
        for (RealEstate estate : realEstateList) {
            estate.displayInfo();
        }
    }
}
