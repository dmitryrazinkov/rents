package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.BussinesCenter;
import rent.repositories.BussinesCenterRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BussinesCenterService {

    @Autowired
    BussinesCenterRepository bussinesCenterRepository;

    @Transactional
    public List<BussinesCenter> allCenters(){
        List<BussinesCenter> bussinesCenterList=new ArrayList<BussinesCenter>();
        for(BussinesCenter b: bussinesCenterRepository.allCenters()){
            bussinesCenterList.add(b);
        }
        return bussinesCenterList;
    }
    @Transactional
    public BussinesCenter add(BussinesCenter b){
        return bussinesCenterRepository.save(b);
    }

    @Transactional
    public BussinesCenter getOne(Integer id){
     return bussinesCenterRepository.findOne(id);
    }

    @Transactional
    public  BussinesCenter update(Integer id, BussinesCenter bussinesCenter){
        BussinesCenter updateBussinesCenter= bussinesCenterRepository.findOne(id);
        updateBussinesCenter.setName(bussinesCenter.getName());
        return bussinesCenterRepository.save(updateBussinesCenter);
    }

    @Transactional
    public void delete(Integer id){
        bussinesCenterRepository.delete(id);
    }
}
