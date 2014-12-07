package rent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import rent.entitys.BussinesCenter;
import rent.repositories.BussinesCenterRepository;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(Config.class, args);
        BussinesCenterRepository bussinesCenterRepository=context.getBean(BussinesCenterRepository.class);
        bussinesCenterRepository.save(new BussinesCenter("Аксиома"));
    }
}
