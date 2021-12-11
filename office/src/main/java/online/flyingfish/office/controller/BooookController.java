package online.flyingfish.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.office.api.BooookApi;
import online.flyingfish.office.entity.Book;
import online.flyingfish.office.service.BooookService;
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
    public void addBook(Book book){
        booookService.addBook(book);
    }

    @ApiOperation(value = "书本信息删除", notes="", httpMethod = "DELETE")
    @Override
    public void delBook(@RequestParam(value="id") int id){
        booookService.delBook(id);
    }

    @ApiOperation(value = "书本信息修改", notes="", httpMethod = "PUT")
    @Override
    public void updBook(Book book){
        booookService.updBook(book);
    }

    @ApiOperation(value = "书本信息详情页", notes="", httpMethod = "GET")
    @Override
    public Book qryBook(@RequestParam(value="id") int id) {
        return booookService.qryBook(id);
    }

    @ApiOperation(value = "书本信息列表页", notes="", httpMethod = "GET")
    @Override
    public List<Book> lstBook() {
        return booookService.list();
    }

}
