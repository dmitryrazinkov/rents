package rent.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rent.entitys.BussinesCenter;

import java.util.List;

@Repository
public interface BussinesCenterRepository extends CrudRepository<BussinesCenter, Integer> {

    @Query("Select b from BussinesCenter b")
    List<BussinesCenter> allCenters();

    @Query("Select b from BussinesCenter b where b.name=:name")
    BussinesCenter findByName(@Param("name") String name);
}
