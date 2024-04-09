package online.flyingfish.biz.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.biz.office.api.BoookApi;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BoookService;
import online.flyingfish.common.dao.coredb.model.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Api("微服务：书本信息管理V3")
@RestController
public class BoookController implements BoookApi {

    @Resource
    private BoookService boookService;

    @ApiOperation(value = "书本信息新增", notes="", httpMethod = "POST")
    @Override
    public void addBook(BookReqVo vo){
        Book po = new Book();

        BeanUtils.copyProperties(vo, po);

        boookService.save(po);
    }

    @ApiOperation(value = "书本信息删除", notes="", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "书本编号", required = true, dataType = "Integer")
    @Override
    public void delBook(@RequestParam(value="id") int id){
        boookService.removeById(id);
    }

    @ApiOperation(value = "书本信息修改", notes="", httpMethod = "PUT")
    @Override
    public void updBook(BookReqVo vo){
        Book po = new Book();

        BeanUtils.copyProperties(vo, po);

        boookService.updateById(po);
    }

    @ApiOperation(value = "书本信息详情页", notes="", httpMethod = "GET")
    @Override
    public BookResVo qryBook(@RequestParam(value="id") int id) {
        Book po = boookService.getById(id);

        BookResVo vo = new BookResVo();
        BeanUtils.copyProperties(po, vo);

        return vo;
    }

    @ApiOperation(value = "书本信息列表页", notes="", httpMethod = "GET")
    @Override
    public List<BookResVo> lstBook() {
        List<Book> pos = boookService.list();

        // po -> vo
        List<BookResVo> vos = pos.stream().map(po -> {
            BookResVo vo = new BookResVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());

        return vos;
    }

}
