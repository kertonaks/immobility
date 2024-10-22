package state;

import service.RealEstateService;

import java.util.Scanner;

public class MainMenuState implements MenuState {
   private final RealEstateService realEstateService;

    public MainMenuState(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

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
                context.setState(new RentMenuState(realEstateService));
                break;
            case 2:
                context.setState(new BuyMenuState(realEstateService));
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                context.setState(new MainMenuState(realEstateService));
                break;
        }

        context.handle();
    }
}
