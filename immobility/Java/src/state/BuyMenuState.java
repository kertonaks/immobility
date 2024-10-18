package state;

import java.util.Scanner;
import service.RealEstateService;
public class BuyMenuState implements MenuState {  // Реалізуємо MenuState
    @Override
    public void handle() {
        System.out.println("Buy Menu:");
        System.out.println("1. Apartment");
        System.out.println("2. House");
        System.out.println("3. Garage");
        System.out.println("4. Sort by Price");
        System.out.println("5. Back to Main Menu");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        MenuContext context = new MenuContext();
        switch (choice) {
            case 1:
                System.out.println("Selected Apartment for Purchase");
                break;
            case 2:
                System.out.println("Selected House for Purchase");
                break;
            case 3:
                System.out.println("Selected Garage for Purchase");
                break;
            case 4:
                RealEstateService realEstateService = new RealEstateService();
                realEstateService.sortByPrice();
                break;
            case 5:
                context.setState(new MainMenuState());
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                context.setState(new BuyMenuState());
                break;
        }

        context.handle();
    }
}
