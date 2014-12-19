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
import java.sql.Date;
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
        boolean checkDates=false;
        if(order.getStartDate()!=null&&order.getEndDate()!=null) {
            checkDates = checkDates(order, roomId);
        }

        if (result.hasErrors() || company == null||order.getStartDate().after(order.getEndDate())||checkDates) {
            List<String> errors = new ArrayList<String>();

            if (result.hasErrors()) {
                errors.add("Enter correct dates(in future).");
            }
            else {
                if (order.getStartDate().after(order.getEndDate())) {
                    errors.add("End date must be after start date");
                }
                if (checkDates) {
                    errors.add("Date conflict with other order for this room");
                }
            }
            if (company == null) {
                errors.add("This company not found. Create this company or enter other");

            }


            if (order.getStartDate()!=null)
                modelMap.addAttribute("startDate",order.getStartDate().toString());
            if (order.getEndDate()!=null)
                modelMap.addAttribute("endDate",order.getEndDate().toString());
            modelMap.addAttribute("errors", errors);
            modelMap.addAttribute("companies", companyService.allCompany());
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

    private boolean checkDates(Orders order, Integer id){
        Date start=order.getStartDate();
        Date end=order.getEndDate();

        for (Orders order1 : ordersService.findByRoomId(id)) {
            if (start.before(order1.getStartDate())&&end.after(order1.getStartDate()))
                return true;
            if (start.before(order1.getEndDate())&&end.after(order1.getEndDate()))
                return true;
            if (start.after(order1.getStartDate())&&end.before(order1.getEndDate()))
                return true;
            if((start.equals(order1.getStartDate()))&&(end.equals(order1.getEndDate())))
                return true;
        }

        return false;
    }
}
