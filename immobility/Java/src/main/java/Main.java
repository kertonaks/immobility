import db.DatabaseConnection;
import service.RealEstateService;
import state.MainMenuState;
import state.MenuContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Initialize context and start the main menu
        //DatabaseConnection.getConnection();
        RealEstateService realEstateService = new RealEstateService();
        MenuContext context = new MenuContext();
        context.setState(new MainMenuState(realEstateService));
        context.handle();
    }
}
