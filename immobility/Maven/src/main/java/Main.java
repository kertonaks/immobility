import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import service.RealEstateService;
public class MainApp {
    public static void main(String[] args) {
        // Ініціалізація Spring контексту
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Отримуємо сервіс через Spring
        RealEstateService realEstateService = context.getBean(RealEstateService.class);

        // Тепер можна використовувати сервіс для взаємодії з даними
        realEstateService.getAllRealEstates().forEach(realEstate -> {
            System.out.println(realEstate.getLocation());
        });
    }
}
