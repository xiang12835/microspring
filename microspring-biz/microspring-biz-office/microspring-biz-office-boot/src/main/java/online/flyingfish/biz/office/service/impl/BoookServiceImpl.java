package online.flyingfish.biz.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.flyingfish.common.dao.coredb.model.Book;
import online.flyingfish.common.dao.coredb.mapper.BoookMapper;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BoookService;
import org.springframework.stereotype.Service;

@Service
public class BoookServiceImpl extends ServiceImpl<BoookMapper, Book> implements BoookService {

}
