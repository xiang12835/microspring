package online.flyingfish.office.h5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // @Controller 返回一个页面
public class ArticleH5 {

    @GetMapping("/h5/article")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "h5") String name, Model model) {
        model.addAttribute("name", name);
        return "h5";
    }

}
