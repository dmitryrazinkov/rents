package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.BussinesCenter;
import rent.repositories.BussinesCenterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BussinesCenterService {

    @Autowired
    BussinesCenterRepository bussinesCenterRepository;

    public List<BussinesCenter> allCenters(){
        List<BussinesCenter> bussinesCenterList=new ArrayList<BussinesCenter>();
        for(BussinesCenter b: bussinesCenterRepository.allCenters()){
            bussinesCenterList.add(b);
        }
        return bussinesCenterList;
    }
}
