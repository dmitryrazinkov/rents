package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.Orders;
import rent.repositories.OdersRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OdersRepository odersRepository;

    @Transactional
    public Orders addOrder(Orders order) {
        return odersRepository.save(order);
    }

    @Transactional
    public List<Orders> findByRoomId(Integer id) {
        List<Orders> ordersList = new ArrayList<Orders>();
        for (Orders order : odersRepository.findByRoomId(id)) {
            ordersList.add(order);
        }
        return ordersList;
    }

    @Transactional
    public void delete(Integer id){
        odersRepository.delete(id);
    }
}
