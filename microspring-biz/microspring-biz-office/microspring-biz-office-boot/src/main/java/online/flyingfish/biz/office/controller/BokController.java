package online.flyingfish.biz.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 */
@RestController
@RequestMapping("/api/office/v1")
@Api("图书api")
public class BokController {

    @Resource
    private BookService bookService;

    @ApiOperation("书本信息新增")
    @RequestMapping(value ="/book_add", method = RequestMethod.POST)
    public void addBook(BookReqVo book){
        bookService.addBook(book);
    }

    @ApiOperation("书本信息删除")
    @ApiImplicitParam(name = "id", value = "书本编号", required = true, dataType = "Integer")
    @RequestMapping(value ="/book_del", method = RequestMethod.DELETE)
    public void delBook(@RequestParam(value="id") int id){
        bookService.delBookById(id);
    }

    @ApiOperation("书本信息修改")
    @RequestMapping(value ="/book_upd", method = RequestMethod.PUT)
    public void updBook(BookReqVo book){
        bookService.updBookById(book);
    }

    @ApiOperation("书本信息详情页")
    @RequestMapping(value ="/book_dtl", method = RequestMethod.GET)
    public BookResVo qryBook(@RequestParam(value="id") int id) {
        return bookService.qryBook(id);
    }

    @ApiOperation("书本信息列表页")
    @RequestMapping(value ="/book_lst", method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "fallback")
    public List<BookResVo> lstBook() {
        return bookService.lstBook();
    }

}
