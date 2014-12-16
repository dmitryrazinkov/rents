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
import rent.Services.BussinesCenterService;
import rent.entitys.BussinesCenter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rent")
public class BussinesCenterController {

    @Autowired
    BussinesCenterService bussinesCenterService;

    @RequestMapping("")
    public String redirect(){
        return "redirect:/rent/center";
    }

    @RequestMapping("/center")
    public String allCenters(ModelMap modelMap){
        modelMap.addAttribute("centerList",bussinesCenterService.allCenters());
        return "all/centers";
    }

    @RequestMapping(value = "/center/add", method = RequestMethod.GET)
    public String addForm(){
        return "all/addCenter";
    }

    @RequestMapping(value = "/center/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("center") @Valid BussinesCenter center, BindingResult result, ModelMap modelMap){
        if (result.hasErrors()){
            List<String> errors=new ArrayList<String>();
            for(FieldError error: result.getFieldErrors()){
                errors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors",errors);
            return "all/addCenter";
        }

        bussinesCenterService.add(center);
        return "redirect:/rent/center";
    }

    @RequestMapping(value = "/center/update/{id}", method = RequestMethod.GET)
    public String updateForm(ModelMap modelMap, @PathVariable Integer id){
        modelMap.addAttribute("center", bussinesCenterService.getOne(id));
        return "all/addCenter";
    }

    @RequestMapping(value = "/center/update/{id}", method = RequestMethod.POST)
    public  String update(@ModelAttribute("center") @Valid BussinesCenter bussinesCenter,BindingResult result, @PathVariable Integer id, ModelMap modelMap){
        if (result.hasErrors()){
            List<String> errors=new ArrayList<String>();
            for(FieldError error: result.getFieldErrors()){
                errors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors",errors);
            return "all/addCenter";
        }

        bussinesCenterService.update(id, bussinesCenter);
        return  "redirect:/rent/center";
    }

    @RequestMapping("/center/delete/{id}")
    public String delete(@PathVariable Integer id,ModelMap modelMap){
        if (bussinesCenterService.getOne(id).getRooms().isEmpty()){
            bussinesCenterService.delete(id);
            return "redirect:/rent/center";
        }
        else{
        modelMap.addAttribute("error","You must delete all rooms before delete bussines center");
            modelMap.addAttribute("centerList",bussinesCenterService.allCenters());
        return "all/centers";
        }
    }
}
