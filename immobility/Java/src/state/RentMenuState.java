package state;

import java.util.Scanner;
import service.RealEstateService;
public class RentMenuState implements MenuState {  // Реалізуємо MenuState
    @Override
    public void handle() {
        System.out.println("Rent Menu:");
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
                System.out.println("Selected Apartment for Rent");
                break;
            case 2:
                System.out.println("Selected House for Rent");
                break;
            case 3:
                System.out.println("Selected Garage for Rent");
                break;
            case 4:
                RealEstateService realEstateService = new RealEstateService();
                realEstateService.sortByPrice();  // Перевірте, що метод `sortByPrice()` існує в RealEstateService
                break;
            case 5:
                context.setState(new MainMenuState());  // Переконайтесь, що MainMenuState імпортовано правильно
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                context.setState(new RentMenuState());
                break;
        }

        context.handle();
    }
}
