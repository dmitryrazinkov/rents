package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import rent.Services.BussinesCenterService;

@Controller
@RequestMapping("/rent")
public class BussinesCenterController {

    @Autowired
    BussinesCenterService bussinesCenterService;

    @RequestMapping("")
    public String allCenters(ModelMap modelMap){
        modelMap.addAttribute("centerList",bussinesCenterService.allCenters());
        return "all/centers";
    }
}
