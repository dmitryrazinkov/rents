package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rent.Services.BussinesCenterService;
import rent.entitys.BussinesCenter;

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
    public String add(@ModelAttribute BussinesCenter center){
        bussinesCenterService.add(center);
        return "redirect:/rent/center";
    }
}
