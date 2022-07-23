# Office

## 项目结构说明

- /api

是对外开放的接口

1. api.BookOpenApi -> controller.open.BookController -> service.BookService -> service.impl.BookServiceImpl -> dao.BookMapper -> resources.mapper.BookMapper.xml
2. api.BookH5Api -> controller.h5.BookController -> service.BookService -> service.impl.BookServiceImpl -> dao.BookMapper -> resources.mapper.BookMapper.xml
3. BookAdminApi
4. BookWebApi

- /h5

h5 页面

1. ArticleH5 -> Controller -> Template

- /admin

是后台管理系统

1. ArticleAdmin -> Controller -> Template

- /web

是网站

1. ArticleWeb -> Controller -> Template


## Build Setup

1. 打开pom.xml

2. 运行数据库

3. 运行 ApiApplication

4. 浏览器打开 http://localhost:9000/swagger-ui.html

## 更新日志

> 20201205更新内容

以 book 为例的 crud 的五个范例

