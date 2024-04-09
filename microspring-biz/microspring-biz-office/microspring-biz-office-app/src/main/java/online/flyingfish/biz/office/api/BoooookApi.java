package online.flyingfish.biz.office.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.flyingfish.biz.office.vo.request.BookReqVo;
import online.flyingfish.biz.office.vo.response.BookResVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("微服务：书本信息管理V5")
@RequestMapping("/api/office/v5")
public interface BoooookApi {

    /**
     * 书本信息新增
     *
     * @param book 书本对象
     */
    @ApiOperation(value = "书本信息新增", httpMethod = "POST")
    @PostMapping(value = "/book_add")
    void addBook(BookReqVo book);

    /**
     * 书本信息删除
     *
     * @param id 书本ID
     */
    @ApiOperation(value = "书本信息删除", httpMethod = "DELETE")
    @DeleteMapping(value = "/book_del")
    void delBook(@RequestParam(value = "id") int id);

    /**
     * 书本信息修改
     *
     * @param book 书本对象
     */
    @ApiOperation(value = "书本信息修改", httpMethod = "PUT")
    @PutMapping(value = "/book_upd")
    void updBook(BookReqVo book);

    /**
     * 书本信息详情页
     *
     * @param id 书本序号
     * @return 书本对象
     */
    @ApiOperation(value = "书本信息详情页", httpMethod = "GET")
    @GetMapping(value = "/book_dtl")
    BookResVo qryBook(@RequestParam(value = "id") int id);

    /**
     * 书本信息列表页
     *
     * @return 书本信息列表
     */
    @ApiOperation(value = "书本信息列表页", httpMethod = "GET")
    @GetMapping(value = "/book_lst")
    List<BookResVo> lstBook();

}
