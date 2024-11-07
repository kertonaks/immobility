package state;

import service.RealEstateService;

import java.util.Scanner;

public class RentMenuState implements MenuState {

    private final RealEstateService realEstateService;

    public RentMenuState(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @Override
    public void handle() {
        System.out.println("Rent Menu:");
        System.out.println("1. Apartment");
        System.out.println("2. House");
        System.out.println("3. Garage");
        System.out.println("4. Sort All Rentals by Price");
        System.out.println("5. Back to Main Menu");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        MenuContext context = new MenuContext();
        switch (choice) {
            case 1:
                System.out.println("Selected Apartment for Rent");
                realEstateService.sortApartmentsByPrice();
                break;
            case 2:
                System.out.println("Selected House for Rent");
                realEstateService.sortHousesByPrice();
                break;
            case 3:
                System.out.println("Selected Garage for Rent");
                realEstateService.sortGaragesByPrice();
                break;
            case 4:
                realEstateService.sortByPrice();
                break;
            case 5:
                context.setState(new MainMenuState(realEstateService));
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                context.setState(new RentMenuState(realEstateService));
                break;
        }

        context.handle();
    }
}
