import service.RealEstateService;
import state.MainMenuState;
import state.MenuContext;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація контексту та стартової сторінки
        RealEstateService realEstateService = new RealEstateService();
        MenuContext context = new MenuContext();
        context.setState(new MainMenuState(realEstateService));
        context.handle();
    }
}
