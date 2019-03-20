package demo;

import com.dean.spi.ExtensionLoader;
import demo.spring.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class ExtensionSPITest {

    @Autowired
    private ExtensionLoader loader;

    @Test
    public void sayHello() throws Exception {
        OrderService japan = (OrderService) loader.getExtensionLoader(OrderService.class).get("japan");
        japan.getOrder("hello.");
        OrderService china = (OrderService) loader.getExtensionLoader(OrderService.class).get("china");
        china.getOrder("worder.");
    }
}
