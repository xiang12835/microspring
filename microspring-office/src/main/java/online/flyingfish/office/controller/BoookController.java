package online.flyingfish.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.office.api.BoookApi;
import online.flyingfish.office.entity.Book;
import online.flyingfish.office.service.BoookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("微服务：书本信息管理V3")
@RestController
public class BoookController implements BoookApi {

    @Resource
    private BoookService boookService;

    @ApiOperation(value = "书本信息新增", notes="", httpMethod = "POST")
    @Override
    public void addBook(Book book){
        boookService.save(book);
    }

    @ApiOperation(value = "书本信息删除", notes="", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "书本编号", required = true, dataType = "Integer")
    @Override
    public void delBook(@RequestParam(value="id") int id){
        boookService.removeById(id);
    }

    @ApiOperation(value = "书本信息修改", notes="", httpMethod = "PUT")
    @Override
    public void updBook(Book book){
        boookService.updateById(book);
    }

    @ApiOperation(value = "书本信息详情页", notes="", httpMethod = "GET")
    @Override
    public Book qryBook(@RequestParam(value="id") int id) {
        return boookService.getById(id);
    }

    @ApiOperation(value = "书本信息列表页", notes="", httpMethod = "GET")
    @Override
    public List<Book> lstBook() {
        return boookService.list();
    }

}
