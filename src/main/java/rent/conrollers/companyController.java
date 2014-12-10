package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import rent.Services.CompanyService;

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
}
