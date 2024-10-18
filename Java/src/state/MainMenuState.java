package state;

import java.util.Scanner;

public class MainMenuState implements MenuState {  // Реалізуємо MenuState
    @Override
    public void handle() {
        System.out.println("Main Menu:");
        System.out.println("1. Rent");
        System.out.println("2. Buy");
        System.out.println("3. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        MenuContext context = new MenuContext();
        switch (choice) {
            case 1:
                context.setState(new RentMenuState());  // Переконайтесь, що RentMenuState реалізує MenuState
                break;
            case 2:
                context.setState(new BuyMenuState());  // Переконайтесь, що BuyMenuState реалізує MenuState
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                context.setState(new MainMenuState());
                break;
        }

        context.handle();
    }
}
