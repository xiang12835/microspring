package online.flyingfish.office.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.flyingfish.office.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BooookMapper extends BaseMapper<Book> {

    //TODO 分页查询待完善

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @Select("select * from book")
    List<Book> lstBook();

}
