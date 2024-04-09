package online.flyingfish.common.dao.coredb.mapper;

import online.flyingfish.common.dao.coredb.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 增加
     *
     * @param book 对象
     */
    @Insert("insert into book(id, name,  price) values(#{id}, #{name}, #{price})")
    void addBook(Book book);

    /**
     * 删除
     *
     * @param id 删除ID
     */
    @Delete("delete from book where id=#{id}")
    void delBookById(@Param("id") int id);

    /**
     * 修改
     *
     * @param name  书名
     * @param price 价格
     * @param id    ID
     */
    @Update("update book set name = #{name}, price = #{price} where id = #{id}")
    void updBookById(@Param("name") String name, @Param("price") float price, @Param("id") int id);

    /**
     * 查询
     *
     * @param id 书的ID
     * @return 查询结果
     */
    @Select("select * from book where id=#{id}")
    Book qryBook(@Param("id") int id);

    /**
     * 分页查询所有书
     *
     * @return 查询结果
     */
    @Select("select * from book limit 10")
    List<Book> lstBook();
}
