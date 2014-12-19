package rent.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import rent.entitys.BussinesCenter;
import rent.entitys.Company;
import rent.entitys.Room;
import rent.repositories.BussinesCenterRepository;
import rent.repositories.CompanyRepository;
import rent.repositories.RoomRepository;

import java.math.BigDecimal;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Config.class, args);
        BussinesCenterRepository bussinesCenterRepository = context.getBean(BussinesCenterRepository.class);
        RoomRepository roomRepository = context.getBean(RoomRepository.class);
        CompanyRepository companyRepository = context.getBean(CompanyRepository.class);

        bussinesCenterRepository.save(new BussinesCenter("Аксиома"));
        bussinesCenterRepository.save(new BussinesCenter("Центр"));
        bussinesCenterRepository.save(new BussinesCenter("Октябрьский"));

        roomRepository.save(new Room(12, bussinesCenterRepository.findByName("Центр"), 2, new BigDecimal(2.1)));
        roomRepository.save(new Room(1, bussinesCenterRepository.findByName("Центр"), 2, new BigDecimal(2.1)));
        roomRepository.save(new Room(2, bussinesCenterRepository.findByName("Аксиома"), 2, new BigDecimal(5)));
        roomRepository.save(new Room(3, bussinesCenterRepository.findByName("Октябрьский"), 1, new BigDecimal(3)));

        companyRepository.save(new Company("DSR", "Иван Иванов", "435663"));
        companyRepository.save(new Company("Company", "Михаил Михайлов", "347690"));
        companyRepository.save(new Company("ООО Альбатрос", "Михаил Иванов", "567890"));
    }
}
