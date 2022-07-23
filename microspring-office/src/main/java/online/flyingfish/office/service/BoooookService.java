package online.flyingfish.office.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.flyingfish.office.entity.Book;

import java.util.List;

public interface BoooookService extends IService<Book> {

    /**
     * 新增
     *
     * @param book 书对象
     */
    void addBook(Book book);

    /**
     * 删除
     *
     * @param id 序号
     */
    void delBook(int id);

    /**
     * 更新
     *
     * @param book 书对象
     */
    void updBook(Book book);

    /**
     * 详情
     *
     * @param id 序号
     * @return 书对象
     */
    Book qryBook(int id);

    /**
     * 分页查询
     *
     * @return 书对象列表
     */
    List<Book> lstBook();


}
