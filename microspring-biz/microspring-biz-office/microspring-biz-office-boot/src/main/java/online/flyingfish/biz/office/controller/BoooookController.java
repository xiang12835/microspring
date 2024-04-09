package online.flyingfish.biz.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.biz.office.api.BoooookApi;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import online.flyingfish.biz.office.service.BoooookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("微服务：书本信息管理V5")
@RestController
public class BoooookController implements BoooookApi {

    @Resource
    private BoooookService boooookService;

    @ApiOperation(value = "书本信息新增", notes="", httpMethod = "POST")
    @Override
    public void addBook(BookReqVo book){
        boooookService.addBook(book);
    }

    @ApiOperation(value = "书本信息删除", notes="", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "书本编号", required = true, dataType = "Integer")
    @Override
    public void delBook(@RequestParam(value="id") int id){
        boooookService.delBook(id);
    }

    @ApiOperation(value = "书本信息修改", notes="", httpMethod = "PUT")
    @Override
    public void updBook(BookReqVo book){
        boooookService.updBook(book);
    }

    @ApiOperation(value = "书本信息详情页", notes="", httpMethod = "GET")
    @Override
    public BookResVo qryBook(@RequestParam(value="id") int id) {
        return boooookService.qryBook(id);
    }

    @ApiOperation(value = "书本信息列表页", notes="", httpMethod = "GET")
    @Override
    public List<BookResVo> lstBook() {
        return boooookService.lstBook();
    }

}
