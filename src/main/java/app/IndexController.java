package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping("/t")
    public @ResponseBody String index() {
        System.out.println("IndexController");
        return "test";
    }
}
