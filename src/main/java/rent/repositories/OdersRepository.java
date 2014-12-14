package rent.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rent.entitys.Orders;

@Repository
public interface OdersRepository extends CrudRepository<Orders,Integer> {

}
