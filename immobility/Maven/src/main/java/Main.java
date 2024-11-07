import DatabaseService.DatabaseService;
import service.RealEstateService;
import state.MainMenuState;
import state.MenuContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseService();

        // Додаємо нову нерухомість
        dbService.addRealEstate("789 Oak Street", 125000.00, "House");

        // Додаємо квартиру
        dbService.addApartment(2, 3);  // Для нерухомості з id 2

        // Оновлюємо ціну для нерухомості з id = 1
        dbService.updateRealEstatePrice(1, 130000.00);

        // Видаляємо нерухомість з id = 4
        dbService.deleteRealEstate(4);
    }
}


