package AppConfig;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Bean;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;  // Імпорт правильного класу для Hibernate

@Configuration
@ComponentScan(basePackages = "com.java")  // Замість 'com.yourpackage' використовуйте ваш пакет
class AppConfig {

    // Бін для Hibernate SessionFactory
    @Bean
    public SessionFactory sessionFactory() {
        // Використовуємо Hibernate Configuration для налаштування Hibernate
        return new Configuration().configure().buildSessionFactory();
    }
}
