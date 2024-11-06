package service;

import db.DatabaseConnection;
import model.Apartment;
import model.Garage;
import model.House;
import model.RealEstate;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RealEstateService {

    // Retrieve all properties from the database
    public List<RealEstate> getAllRealEstates() {
        List<RealEstate> realEstateList = new ArrayList<>();
        String query = "SELECT * FROM RealEstate";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String location = rs.getString("location");
                double price = rs.getDouble("price");

                switch (type) {
                    case "Apartment":
                        int rooms = getApartmentRooms(id);
                        realEstateList.add(new Apartment(id, location, price, rooms));
                        break;
                    case "House":
                        double area = getHouseArea(id);
                        realEstateList.add(new House(id, location, price, area));
                        break;
                    case "Garage":
                        boolean hasElectricity = getGarageElectricity(id);
                        realEstateList.add(new Garage(id, location, price, hasElectricity));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realEstateList;
    }

    // Retrieve a single property by its ID
    public RealEstate getRealEstateById(int id) {
        RealEstate realEstate = null;
        String query = "SELECT * FROM RealEstate WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String type = rs.getString("type");
                String location = rs.getString("location");
                double price = rs.getDouble("price");

                switch (type) {
                    case "Apartment":
                        int rooms = getApartmentRooms(id);
                        realEstate = new Apartment(id, location, price, rooms);
                        break;
                    case "House":
                        double area = getHouseArea(id);
                        realEstate = new House(id, location, price, area);
                        break;
                    case "Garage":
                        boolean hasElectricity = getGarageElectricity(id);
                        realEstate = new Garage(id, location, price, hasElectricity);
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realEstate;
    }

    // Retrieve apartment rooms by ID
    private int getApartmentRooms(int id) {
        String query = "SELECT rooms FROM Apartment WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("rooms");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Retrieve house area by ID
    private double getHouseArea(int id) {
        String query = "SELECT area FROM House WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("area");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Retrieve garage electricity status by ID
    private boolean getGarageElectricity(int id) {
        String query = "SELECT hasElectricity FROM Garage WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("hasElectricity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Sort and display all properties by price
    public void sortByPrice() {
        List<RealEstate> realEstateList = getAllRealEstates();
        realEstateList.sort(Comparator.comparing(RealEstate::getPrice));
        System.out.println("Sorted by Price:");
        for (RealEstate estate : realEstateList) {
            estate.displayInfo();
        }
    }

    // Sort properties by type and price
    public void sortApartmentsByPrice() {
        List<RealEstate> apartments = filterAndSort("Apartment");
        System.out.println("Sorted Apartments by Price:");
        apartments.forEach(RealEstate::displayInfo);
    }

    public void sortHousesByPrice() {
        List<RealEstate> houses = filterAndSort("House");
        System.out.println("Sorted Houses by Price:");
        houses.forEach(RealEstate::displayInfo);
    }

    public void sortGaragesByPrice() {
        List<RealEstate> garages = filterAndSort("Garage");
        System.out.println("Sorted Garages by Price:");
        garages.forEach(RealEstate::displayInfo);
    }

    // Helper method to filter by type and sort by price
    private List<RealEstate> filterAndSort(String type) {
        List<RealEstate> filteredList = new ArrayList<>();
        for (RealEstate estate : getAllRealEstates()) {
            if (estate.getClass().getSimpleName().equals(type)) {
                filteredList.add(estate);
            }
        }
        filteredList.sort(Comparator.comparing(RealEstate::getPrice));
        return filteredList;
    }
}
