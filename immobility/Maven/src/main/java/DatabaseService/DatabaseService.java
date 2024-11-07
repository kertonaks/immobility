package DatabaseService;

import java.sql.*;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://192.168.56.1:3306/java_database";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";  // Замініть на свій пароль

    // Метод для отримання з'єднання з базою даних
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Метод для перевірки існування запису в таблиці RealEstate за ID
    public boolean realEstateExists(int id) {
        String query = "SELECT COUNT(*) FROM RealEstate WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Метод для додавання нового запису в таблицю RealEstate
    public boolean addRealEstate(String location, double price, String type) {
        String query = "INSERT INTO RealEstate (location, price, type) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, location);
            stmt.setDouble(2, price);
            stmt.setString(3, type);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Метод для додавання квартири в таблицю Apartment
    public boolean addApartment(int id, int rooms) {
        if (!realEstateExists(id)) {
            System.out.println("Real estate not found for apartment.");
            return false;
        }
        String query = "INSERT INTO Apartment (id, rooms) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setInt(2, rooms);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Метод для додавання будинку в таблицю House
    public boolean addHouse(int id, double area) {
        if (!realEstateExists(id)) {
            System.out.println("Real estate not found for house.");
            return false;
        }
        String query = "INSERT INTO House (id, area) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setDouble(2, area);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Метод для додавання гаража в таблицю Garage
    public boolean addGarage(int id, boolean hasElectricity) {
        if (!realEstateExists(id)) {
            System.out.println("Real estate not found for garage.");
            return false;
        }
        String query = "INSERT INTO Garage (id, hasElectricity) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setBoolean(2, hasElectricity);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Метод для оновлення ціни нерухомості
    public boolean updateRealEstatePrice(int id, double newPrice) {
        if (!realEstateExists(id)) {
            System.out.println("Real estate not found.");
            return false;
        }
        String query = "UPDATE RealEstate SET price = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Метод для видалення нерухомості
    public boolean deleteRealEstate(int id) {
        if (!realEstateExists(id)) {
            System.out.println("Real estate not found.");
            return false;
        }
        String query = "DELETE FROM RealEstate WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
