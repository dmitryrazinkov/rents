package rent.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class AnyController {
    @RequestMapping("")
    public String index(){
        return "all/index";
    }
}
