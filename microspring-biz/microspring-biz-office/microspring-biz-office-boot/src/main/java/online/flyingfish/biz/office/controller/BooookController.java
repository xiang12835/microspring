package online.flyingfish.biz.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.biz.office.api.BooookApi;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BooookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("微服务：书本信息管理V4")
@RestController
public class BooookController implements BooookApi {

    @Resource
    private BooookService booookService;

    @ApiOperation(value = "书本信息新增", notes="", httpMethod = "POST")
    @Override
    public void addBook(BookReqVo book){
        booookService.addBook(book);
    }

    @ApiOperation(value = "书本信息删除", notes="", httpMethod = "DELETE")
    @Override
    public void delBook(@RequestParam(value="id") int id){
        booookService.delBook(id);
    }

    @ApiOperation(value = "书本信息修改", notes="", httpMethod = "PUT")
    @Override
    public void updBook(BookReqVo book){
        booookService.updBook(book);
    }

    @ApiOperation(value = "书本信息详情页", notes="", httpMethod = "GET")
    @Override
    public BookResVo qryBook(@RequestParam(value="id") int id) {
        return booookService.qryBook(id);
    }

    @ApiOperation(value = "书本信息列表页", notes="", httpMethod = "GET")
    @Override
    public List<BookResVo> lstBook() {
        return booookService.lstBook();
    }

}
