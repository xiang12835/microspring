package online.flyingfish.office.h5;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface ArticleH5 {

    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "h5") String name, Model model);

}
