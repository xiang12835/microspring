package online.flyingfish.office.service.impl;

import online.flyingfish.office.entity.Book;
import online.flyingfish.office.dao.BookMapper;
import online.flyingfish.office.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    // 增加
    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    // 删除
    @Override
    public void delBookById(int id) {
        bookMapper.delBookById(id);
    }

    // 修改
    @Override
    public void updBookById(Book book) {
        bookMapper.updBookById(book.getName(),book.getPrice(),book.getId());
    }

    // 详情
    @Override
    public Book qryBook(int id) {
        return bookMapper.qryBook(id);
    }

    // 列表
    @Override
    public List<Book> lstBook() {
        return bookMapper.lstBook();
    }
}
