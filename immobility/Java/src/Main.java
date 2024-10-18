

import state.MainMenuState;
import state.MenuContext;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація контексту та стартової сторінки
        MenuContext context = new MenuContext();
        context.setState(new MainMenuState());
        context.handle();
    }
}
