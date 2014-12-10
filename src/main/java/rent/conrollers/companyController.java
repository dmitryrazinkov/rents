package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rent.Services.CompanyService;
import rent.entitys.Company;

@Controller
@RequestMapping("rent/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping("")
    public String allCompanies(ModelMap modelMap){
        modelMap.addAttribute("companiesList",companyService.allCompany());
        return "all/companies";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(){
        return "all/addCompany";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Company company){
        companyService.add(company);
        return "redirect:/rent/company";
    }
}
