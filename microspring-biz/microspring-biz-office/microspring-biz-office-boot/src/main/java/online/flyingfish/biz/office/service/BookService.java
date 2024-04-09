package online.flyingfish.biz.office.service;

import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;

import java.util.List;

public interface BookService {

    /**
     * 增加
     *
     * @param book 书对象
     */
    void addBook(BookReqVo book);

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
    void updBookById(BookReqVo book);

    /**
     * 查询详情
     *
     * @param id 书的ID
     * @return 查询的对象
     */
    BookResVo qryBook(int id);

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    List<BookResVo> lstBook();
}
