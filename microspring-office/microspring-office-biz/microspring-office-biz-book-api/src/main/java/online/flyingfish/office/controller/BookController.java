package online.flyingfish.office.controller;

import online.flyingfish.office.api.BookApi;
import online.flyingfish.office.entity.Book;
import online.flyingfish.office.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("微服务：书本信息管理V1")
@RestController
public class BookController implements BookApi {

    @Resource
    private BookService bookService;

    @ApiOperation(value = "书本信息新增", notes="", httpMethod = "POST")
    @Override
    public void addBook(Book book){
        bookService.addBook(book);
    }

    @ApiOperation(value = "书本信息删除", notes="", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "书本编号", required = true, dataType = "Integer")
    @Override
    public void delBook(@RequestParam(value="id") int id){
        bookService.delBookById(id);
    }

    @ApiOperation(value = "书本信息修改", notes="", httpMethod = "PUT")
    @Override
    public void updBook(Book book){
        bookService.updBookById(book);
    }

    @ApiOperation(value = "书本信息详情页", notes="", httpMethod = "GET")
    @Override
    public Book qryBook(@RequestParam(value="id") int id) {
        return bookService.qryBook(id);
    }

    @ApiOperation(value = "书本信息列表页", notes="", httpMethod = "GET")
    @Override
    public List<Book> lstBook() {
        return bookService.lstBook();
    }

}
