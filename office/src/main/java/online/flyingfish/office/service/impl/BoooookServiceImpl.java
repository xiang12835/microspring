package online.flyingfish.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.flyingfish.office.dao.BoooookMapper;
import online.flyingfish.office.entity.Book;
import online.flyingfish.office.service.BoooookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoooookServiceImpl extends ServiceImpl<BoooookMapper, Book> implements BoooookService {

    @Resource
    private BoooookMapper boooookMapper;

    // 增加
    @Override
    public void addBook(Book book) {
        boooookMapper.addBook(book);
    }

    // 删除
    @Override
    public void delBook(int id) {
        boooookMapper.delBook(id);
    }

    // 修改
    @Override
    public void updBook(Book book) {
        boooookMapper.updBook(book.getName(),book.getPrice(),book.getId());
    }

    // 详情
    @Override
    public Book qryBook(int id) {
        return boooookMapper.qryBook(id);
    }

    // 列表
    @Override
    public List<Book> lstBook() {
        return boooookMapper.lstBook();
    }

}
