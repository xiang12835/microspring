package online.flyingfish.biz.office.service.impl;

import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.common.dao.coredb.model.Book;
import online.flyingfish.common.dao.coredb.mapper.BookMapper;
import online.flyingfish.biz.office.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    // 增加
    @Override
    public void addBook(BookReqVo vo) {
        Book po = new Book();

        BeanUtils.copyProperties(vo, po);

        bookMapper.addBook(po);
    }

    // 删除
    @Override
    public void delBookById(int id) {
        bookMapper.delBookById(id);
    }

    // 修改
    @Override
    public void updBookById(BookReqVo book) {
        bookMapper.updBookById(book.getName(),book.getPrice(),book.getId());
    }

    // 详情
    @Override
    public BookResVo qryBook(int id) {
        BookResVo vo = new BookResVo();

        Book po = bookMapper.qryBook(id);
        BeanUtils.copyProperties(po, vo);

        return vo;
    }

    // 列表
    @Override
    public List<BookResVo> lstBook() {
        List<Book> pos = bookMapper.lstBook();

        // po -> vo
        List<BookResVo> vos = pos.stream().map(po -> {
            BookResVo vo = new BookResVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());

        return vos;
    }
}
