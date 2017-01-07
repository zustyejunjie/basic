package net.xuele.basic.service;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-test.xml",
        "classpath:spring/application-quartz.xml"}) // 加载配置

public abstract class TestSupport {
}
