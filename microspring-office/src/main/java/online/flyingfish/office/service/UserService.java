package online.flyingfish.office.service;

import online.flyingfish.office.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserService {

    void addUser(User user);

    void delUserById(@Param("id") int id);

    void updateUserById(User user);

    List<User> getUser();
}
