package online.flyingfish.office.dao;

import java.util.List;

import online.flyingfish.office.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert({"insert into user(id, name, email) values(#{id}, #{name}, #{email})"})
    void addUser(User userInfo);

    @Delete("delete from user where id=#{id}")
    void delUserById(@Param("id") int id);

    @Update("update user set name = #{name}, email = #{email} where id = #{id}")
    void updateUserById(@Param("name") String name, @Param("email") String email, @Param("id") int id);

    @Select("select * from user")
    List<User> getUser();
}
