package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rent.Services.BussinesCenterService;
import rent.Services.RoomService;
import rent.entitys.BussinesCenter;
import rent.entitys.Room;

@Controller
@RequestMapping("/rent/center/{id}")
public class RoomController {
    @Autowired
    BussinesCenterService bussinesCenterService;

    @Autowired
    RoomService roomService;


    @RequestMapping("")
    public String allRooms(@PathVariable Integer id, ModelMap modelMap ){
        modelMap.addAttribute(bussinesCenterService.getOne(id).getRooms());
        modelMap.addAttribute("id",id);
        return("all/rooms");

    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.GET)
    public String addRoom(){
        return "all/addRoom";
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    public String addRoom(@PathVariable Integer id, @ModelAttribute Room room){
        BussinesCenter b=bussinesCenterService.getOne(id);
        room= roomService.addRoom(new Room(room.getNum(),b,room.getFloor(),room.getArea()));
        b.getRooms().add(room);
        return "redirect:/rent/center/{id}";
    }

}
