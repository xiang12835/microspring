package online.flyingfish.biz.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.flyingfish.common.dao.coredb.model.Book;
import online.flyingfish.common.dao.coredb.mapper.BooookMapper;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BooookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooookServiceImpl extends ServiceImpl<BooookMapper, Book> implements BooookService {

    @Resource
    private BooookMapper booookMapper;

    // 增加
    @Override
    public void addBook(BookReqVo vo) {
        Book po = new Book();

        BeanUtils.copyProperties(vo, po);

        booookMapper.insert(po);
    }

    // 删除
    @Override
    public void delBook(int id) {
        booookMapper.deleteById(id);
    }

    // 修改
    @Override
    public void updBook(BookReqVo vo) {
        Book po = new Book();

        BeanUtils.copyProperties(vo, po);

        booookMapper.updateById(po);
    }

    // 详情
    @Override
    public BookResVo qryBook(int id) {
        Book po = booookMapper.selectById(id);

        BookResVo vo = new BookResVo();
        BeanUtils.copyProperties(po, vo);

        return vo;
    }

    // 列表
    @Override
    public List<BookResVo> lstBook() {
        List<Book> pos = booookMapper.lstBook();

        // po -> vo
        List<BookResVo> vos = pos.stream().map(po -> {
            BookResVo vo = new BookResVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());

        return vos;
    }

}
