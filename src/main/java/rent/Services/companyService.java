package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.Company;
import rent.repositories.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> allCompany(){
        List<Company> companies=new ArrayList<Company>();
        for(Company company: companyRepository.allCompanys()){
            companies.add(company);
        }
        return companies;

    }

    public Company findByName(String name){
        return companyRepository.findByName(name);
    }

    public Company add(Company company){
        return companyRepository.save(company);
    }

}
