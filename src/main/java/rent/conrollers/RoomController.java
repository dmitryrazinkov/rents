package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rent.Services.BussinesCenterService;

@Controller
@RequestMapping("/rent/center")
public class RoomController {
    @Autowired
    BussinesCenterService bussinesCenterService;


    @RequestMapping("/{id}")
    public String allRooms(@PathVariable Integer id, ModelMap modelMap ){
        modelMap.addAttribute(bussinesCenterService.getOne(id).getRooms());
        return("all/rooms");
    }

}
