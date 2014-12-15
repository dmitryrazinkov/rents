package rent.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rent.entitys.Orders;

import java.util.List;

@Repository
public interface OdersRepository extends CrudRepository<Orders,Integer> {

    List<Orders> findByRoomId(Integer id);
}
