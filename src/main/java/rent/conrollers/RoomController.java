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
import rent.Services.RoomService;
import rent.entitys.BussinesCenter;
import rent.entitys.Room;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rent/center/{id}")
public class RoomController {
    @Autowired
    BussinesCenterService bussinesCenterService;

    @Autowired
    RoomService roomService;


    @RequestMapping("")
    public String allRooms(@PathVariable Integer id, ModelMap modelMap) {
        BussinesCenter bussinesCenter = bussinesCenterService.getOne(id);
        modelMap.addAttribute("center", bussinesCenter.getName());

        List<Room> rooms = bussinesCenter.getRooms();
        if (rooms != null) modelMap.addAttribute(rooms);
        modelMap.addAttribute("id", id);
        return ("all/rooms");

    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.GET)
    public String addRoom(ModelMap modelMap, @PathVariable Integer id) {

        modelMap.addAttribute("id", id);

        return "all/addRoom";
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    public String addRoom(@PathVariable Integer id, @ModelAttribute("room") @Valid Room room, BindingResult result,
                          ModelMap modelMap) {
        if (result.hasErrors()) {
            room.setId(null);
            List<String> errors = new ArrayList<String>();
            for (FieldError error : result.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors", errors);
            return "all/addRoom";
        }

        modelMap.addAttribute("id", id);

        BussinesCenter b = bussinesCenterService.getOne(id);
        room = roomService.addRoom(new Room(room.getNum(), b, room.getFloor(), room.getArea()));
        b.getRooms().add(room);
        return "redirect:/rent/center/{id}";
    }


    @RequestMapping(value = "/update/{roomId}", method = RequestMethod.GET)
    public String updateRoom(ModelMap modelMap, @PathVariable Integer id, @PathVariable Integer roomId) {
        modelMap.addAttribute("room", roomService.findOne(roomId));
        modelMap.addAttribute("id", id);

        return "all/addRoom";
    }

    @RequestMapping(value = "/update/{roomId}", method = RequestMethod.POST)
    public String updateRoom(@PathVariable Integer id, @ModelAttribute("room") @Valid Room room, BindingResult result,
                             ModelMap modelMap, @PathVariable Integer roomId) {
        if (result.hasErrors()) {

            List<String> errors = new ArrayList<String>();
            for (FieldError error : result.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors", errors);
            return "all/addRoom";
        }

        modelMap.addAttribute("id", id);

        BussinesCenter b = bussinesCenterService.getOne(id);
        room = roomService.update(roomId, room);

        // for(Room room1: b.getRooms()){
        //     if (room1.getId()==room.getId())
        //         b.getRooms().remove(room1);
        // }
        /*
        Iterator<Room> it = b.getRooms().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == room.getId())
                it.remove();

        }

        b.getRooms().add(room);
        */
        return "redirect:/rent/center/{id}";

    }

    @RequestMapping("/delete/{roomId}")
    public String delete(@PathVariable Integer roomId, @PathVariable Integer id, ModelMap modelMap) {
        Room room = roomService.findOne(roomId);
        BussinesCenter b = bussinesCenterService.getOne(id);

        if (room.getOrders().isEmpty()) {
            /*
            Iterator<Room> it = b.getRooms().iterator();
            while (it.hasNext()) {
                if (it.next().getId() == roomId) {
                    it.remove();

                }


            }
            */

            roomService.delete(roomId);
            return "redirect:/rent/center/{id}";
        } else {
            modelMap.addAttribute("error", "You must delete all orders before delete room");
            List<Room> rooms = b.getRooms();
            if (rooms != null) modelMap.addAttribute(rooms);
            return "all/rooms";
        }
    }


}
