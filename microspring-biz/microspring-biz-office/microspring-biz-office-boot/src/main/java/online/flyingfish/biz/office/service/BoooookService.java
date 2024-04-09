package online.flyingfish.biz.office.service;

import online.flyingfish.common.dao.coredb.model.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import java.util.List;

public interface BoooookService extends IService<Book> {

    /**
     * 新增
     *
     * @param book 书对象
     */
    void addBook(BookReqVo book);

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
    void updBook(BookReqVo book);

    /**
     * 详情
     *
     * @param id 序号
     * @return 书对象
     */
    BookResVo qryBook(int id);

    /**
     * 分页查询
     *
     * @return 书对象列表
     */
    List<BookResVo> lstBook();


}
