package online.flyingfish.office.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.flyingfish.office.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoooookMapper extends BaseMapper<Book> {

    // 增加
    void addBook(Book book);

    // 删除
    void delBook(@Param("id") int id);

    // 修改
    void updBook(@Param("name") String name, @Param("price") float price, @Param("id") int id);

    // 查询
    Book qryBook(@Param("id") int id);

    // 分页
    List<Book> lstBook();

}
