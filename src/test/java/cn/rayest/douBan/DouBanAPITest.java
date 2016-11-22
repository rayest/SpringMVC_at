package cn.rayest.douBan;

import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rayest on 2016/11/22 0022.
 */
// http://api.douban.com/v2/book/1220562  GET 请求豆瓣书籍信息
public class DouBanAPITest {
    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://api.douban.com/v2/book";
        RestAssured.port = 80;
    }

    @Test
    public void test() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}
