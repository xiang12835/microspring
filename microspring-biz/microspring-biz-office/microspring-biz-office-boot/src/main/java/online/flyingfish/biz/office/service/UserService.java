package online.flyingfish.biz.office.service;

import online.flyingfish.common.dao.coredb.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserService {

    void addUser(User user);

    void delUserById(@Param("id") int id);

    void updateUserById(User user);

    List<User> getUser();
}
