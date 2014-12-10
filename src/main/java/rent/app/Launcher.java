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
        ApplicationContext context= SpringApplication.run(Config.class, args);
        BussinesCenterRepository bussinesCenterRepository=context.getBean(BussinesCenterRepository.class);
        RoomRepository roomRepository=context.getBean(RoomRepository.class);
        CompanyRepository companyRepository=context.getBean(CompanyRepository.class);
        bussinesCenterRepository.save(new BussinesCenter("Аксиома"));
        roomRepository.save(new Room(12,bussinesCenterRepository.findByName("Аксиома"),2,new BigDecimal(2.1)));
        roomRepository.save(new Room(1,bussinesCenterRepository.findByName("Аксиома"),2,new BigDecimal(2.1)));
        companyRepository.save(new Company("DSR","Иван","435663"));
    }
}
