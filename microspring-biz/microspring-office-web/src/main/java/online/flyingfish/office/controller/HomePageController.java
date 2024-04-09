package online.flyingfish.office.controller;

import online.flyingfish.office.web.HomePage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // @Controller 返回一个页面
public class HomePageController implements HomePage {

    @GetMapping("/index")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "web") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
