package online.flyingfish.office.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface HomePage {

    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "h5") String name, Model model);

}
