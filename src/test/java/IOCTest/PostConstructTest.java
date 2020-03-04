package IOCTest;

import com.wy.annotation.config.MainConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname PostContructor
 * @Description @PostCont
 * @Date 2020/3/4 0004 21:57
 * @Created by wy
 */
public class PostConstructTest {
    @Test
    public void postConstruct() {
        // 创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
       // annotationConfigApplicationContext.close();
    }
}
