package rent.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rent.entitys.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query("Select c from Company c")
    List<Company> allCompanys();

    Company findByName(String name);

}
