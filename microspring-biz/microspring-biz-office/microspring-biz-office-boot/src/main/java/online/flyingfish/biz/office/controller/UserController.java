package online.flyingfish.biz.office.controller;

import online.flyingfish.common.dao.coredb.model.User;
import online.flyingfish.biz.office.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/office/v1")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> userQry() {
        return userService.getUser();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void userAdd(User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void userUpd(User user) {
        userService.updateUserById(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void userDel(@RequestParam(value = "id") int id) {
        userService.delUserById(id);
    }
}
