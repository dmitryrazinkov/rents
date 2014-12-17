package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.Company;
import rent.repositories.CompanyRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Transactional
    public List<Company> allCompany(){
        List<Company> companies=new ArrayList<Company>();
        for(Company company: companyRepository.allCompanys()){
            companies.add(company);
        }
        return companies;

    }

    @Transactional
    public Company findByName(String name){
        return companyRepository.findByName(name);
    }

    @Transactional
    public Company add(Company company){
        return companyRepository.save(company);
    }

    @Transactional
    public void delete(Integer id){
        companyRepository.delete(id);
    }

    @Transactional
    public Company update(Integer id, Company company){
        Company updateCompany=companyRepository.findOne(id);
        updateCompany.setName(company.getName());
        updateCompany.setContact(company.getContact());
        updateCompany.setTel(company.getTel());
        return companyRepository.save(updateCompany);
    }

    @Transactional
    public Company findOne(Integer id){
        return companyRepository.findOne(id);
    }
}
