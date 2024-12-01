package online.flyingfish.biz.office.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureTestDatabase
public class DBTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM book LIMIT 1");
        System.out.println("============> ");
        System.out.println(rows);
    }


}
