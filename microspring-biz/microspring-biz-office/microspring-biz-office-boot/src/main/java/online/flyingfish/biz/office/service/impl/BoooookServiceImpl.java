package online.flyingfish.biz.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.flyingfish.common.dao.coredb.model.Book;
import online.flyingfish.common.dao.coredb.mapper.BoooookMapper;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BoooookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoooookServiceImpl extends ServiceImpl<BoooookMapper, Book> implements BoooookService {

    @Resource
    private BoooookMapper boooookMapper;

    // 增加
    @Override
    public void addBook(BookReqVo vo) {
        Book po = new Book();

        BeanUtils.copyProperties(vo, po);

        boooookMapper.addBook(po);
    }

    // 删除
    @Override
    public void delBook(int id) {
        boooookMapper.delBook(id);
    }

    // 修改
    @Override
    public void updBook(BookReqVo vo) {
        boooookMapper.updBook(vo.getName(), vo.getPrice(), vo.getId());
    }

    // 详情
    @Override
    public BookResVo qryBook(int id) {
        Book po = boooookMapper.qryBook(id);

        BookResVo vo = new BookResVo();
        BeanUtils.copyProperties(vo, po);

        return vo;
    }

    // 列表
    @Override
    public List<BookResVo> lstBook() {
        List<Book> pos = boooookMapper.lstBook();

        // po -> vo
        List<BookResVo> vos = pos.stream().map(po -> {
            BookResVo vo = new BookResVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());

        return vos;
    }

}
