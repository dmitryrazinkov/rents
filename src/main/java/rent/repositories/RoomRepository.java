package rent.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rent.entitys.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
}
