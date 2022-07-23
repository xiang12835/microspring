package online.flyingfish.office.service;

import online.flyingfish.office.entity.Book;

import java.util.List;

public interface BookService {

    /**
     * 增加
     *
     * @param book 书对象
     */
    void addBook(Book book);

    /**
     * 删除
     *
     * @param id 序号
     */
    void delBookById(int id);

    /**
     * 修改
     *
     * @param book 书对象
     */
    void updBookById(Book book);

    /**
     * 查询详情
     *
     * @param id 书的ID
     * @return 查询的对象
     */
    Book qryBook(int id);

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    List<Book> lstBook();
}
