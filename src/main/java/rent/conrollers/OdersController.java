package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rent.Services.CompanyService;
import rent.Services.OrdersService;
import rent.Services.RoomService;
import rent.entitys.Company;
import rent.entitys.Orders;
import rent.entitys.Room;

@Controller
@RequestMapping("rent/center/{id}")
public class OdersController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    RoomService roomService;

    @Autowired
    CompanyService companyService;



    @RequestMapping(value = "/{roomId}/addOrder", method = RequestMethod.GET)
    public String addForm(@PathVariable Integer id,@PathVariable Integer roomId, ModelMap modelMap){
        modelMap.addAttribute("roomId",roomId);
        modelMap.addAttribute("id",id);

        return "all/addOrder";
    }


    @RequestMapping(value = "/{roomId}/addOrder", method = RequestMethod.POST)
    public String addOrders(@PathVariable Integer id,@PathVariable Integer roomId, @ModelAttribute Company company, @ModelAttribute Orders order,ModelMap modelMap){


        company=companyService.findByName(company.getName());
        Room room=roomService.findOne(roomId);
        order=ordersService.addOrder(new Orders(order.getStartDate(),order.getEndDate(),company,room));
        company.getOrders().add(order);
        room.getOrders().add(order);

        return "redirect:/rent/center/{id}";
    }
}
