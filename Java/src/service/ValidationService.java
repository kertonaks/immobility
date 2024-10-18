package service;

public class ValidationService {
    public boolean isValidPrice(double price) {
        return price > 0;
    }

    public boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }
}
