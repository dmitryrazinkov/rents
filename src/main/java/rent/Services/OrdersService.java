package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.Orders;
import rent.repositories.OdersRepository;

@Service
public class OrdersService {
    @Autowired
    OdersRepository odersRepository;

    public Orders addOrder(Orders order){
        return odersRepository.save(order);
    }


}
