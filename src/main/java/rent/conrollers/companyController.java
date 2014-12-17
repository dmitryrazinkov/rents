package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rent.Services.CompanyService;
import rent.entitys.Company;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String add(@ModelAttribute("company") @Valid Company company, BindingResult result, ModelMap modelMap){
        if (result.hasErrors()){
            List<String> errors=new ArrayList<String>();
            for(FieldError error: result.getFieldErrors()){
                errors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors",errors);
            return "all/addCompany";
        }

        companyService.add(company);
        return "redirect:/rent/company";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(ModelMap modelMap, @PathVariable Integer id)
    {
        modelMap.addAttribute("company",companyService.findOne(id));
        return "all/addCompany";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("company") @Valid Company company, BindingResult result, ModelMap modelMap, @PathVariable Integer id){
        if (result.hasErrors()){
            List<String> errors=new ArrayList<String>();
            for(FieldError error: result.getFieldErrors()){
                errors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors",errors);
            return "all/addCompany";
        }

        companyService.update(id, company);
        return "redirect:/rent/company";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,ModelMap modelMap){
        if (companyService.findOne(id).getOrders().isEmpty()){
            companyService.delete(id);
            return "redirect:/rent/company";
        }
        else{
            modelMap.addAttribute("error","You must delete all orders before delete company");
            modelMap.addAttribute("companiesList",companyService.allCompany());
            return "all/companies";
        }
    }
}
