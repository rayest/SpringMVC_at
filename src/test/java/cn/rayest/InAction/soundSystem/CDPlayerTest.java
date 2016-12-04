package cn.rayest.InAction.soundSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Rayest on 2016/12/4 0004.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 创建 spring 上下文
@ContextConfiguration(classes = CDPlayerConfig.class) // 加载具体的配置
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Test
    public void testCDShouldNotNull() throws Exception {
        assertNotNull(cd);
    }
}
