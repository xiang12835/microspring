package online.flyingfish.office.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.flyingfish.office.dao.BoookMapper;
import online.flyingfish.office.entity.Book;
import online.flyingfish.office.service.BoookService;
import org.springframework.stereotype.Service;

@Service
public class BoookServiceImpl extends ServiceImpl<BoookMapper, Book> implements BoookService {

}
