package online.flyingfish.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.flyingfish.office.dao.BookMapper;
import online.flyingfish.office.dao.BooookMapper;
import online.flyingfish.office.entity.Book;
import online.flyingfish.office.service.BooookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooookServiceImpl extends ServiceImpl<BooookMapper, Book> implements BooookService {

    @Resource
    private BooookMapper booookMapper;

    // 增加
    @Override
    public void addBook(Book book) {
        booookMapper.insert(book);
    }

    // 删除
    @Override
    public void delBook(int id) {
        booookMapper.deleteById(id);
    }

    // 修改
    @Override
    public void updBook(Book book) {
        booookMapper.updateById(book);
    }

    // 详情
    @Override
    public Book qryBook(int id) {
        return booookMapper.selectById(id);
    }

    // 列表
    @Override
    public List<Book> lstBook() {
        return booookMapper.lstBook();
    }

}
