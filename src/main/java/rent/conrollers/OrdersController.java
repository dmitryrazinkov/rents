package rent.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rent/center/{id}")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    RoomService roomService;

    @Autowired
    CompanyService companyService;

    @RequestMapping("/{roomId}")
    public String orders(@PathVariable Integer id, @PathVariable Integer roomId, ModelMap modelMap) {
        modelMap.addAttribute("roomId", roomId);
        modelMap.addAttribute("id",id);
        modelMap.addAttribute("orderList", ordersService.findByRoomId(roomId));

        modelMap.addAttribute("roomNum", roomService.findOne(roomId).getNum());
        return "all/orders";
    }


    @RequestMapping(value = "/{roomId}/addOrder", method = RequestMethod.GET)
    public String addForm(@PathVariable Integer id, @PathVariable Integer roomId, ModelMap modelMap) {
        modelMap.addAttribute("roomId", roomId);
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("companies",companyService.allCompany());

        return "all/addOrder";
    }


    @RequestMapping(value = "/{roomId}/addOrder", method = RequestMethod.POST)
    public String addOrders(@PathVariable Integer id, @PathVariable Integer roomId, @ModelAttribute Company company,
                            @ModelAttribute @Valid Orders order, BindingResult result, ModelMap modelMap) {
        company = companyService.findByName(company.getName());

        if (result.hasErrors() || company == null) {
            List<String> errors = new ArrayList<String>();

            if (result.hasErrors()) {
                errors.add("Enter correct dates(in future).");
            }
            if (company == null) {
                errors.add("This company not found. Create this company or enter other");

            }
            modelMap.addAttribute("errors", errors);
            modelMap.addAttribute("companies",companyService.allCompany());
            return "all/addOrder";
        }

        Room room = roomService.findOne(roomId);
        order = ordersService.addOrder(new Orders(order.getStartDate(), order.getEndDate(), company, room));
        company.getOrders().add(order);
        room.getOrders().add(order);

        return "redirect:/rent/center/{id}/{roomId}";
    }

    @RequestMapping("/{roomId}/delete/{orderId}")
    public String delete(@PathVariable() Integer orderId){
        ordersService.delete(orderId);
        return "redirect:/rent/center/{id}/{roomId}";
    }

}
