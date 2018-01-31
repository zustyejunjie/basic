package AES;

import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 可获取config配置文件相关参数值
 * Created by wnw on 2016/10/11.
 */
public class PropertyUtil {
    private static final Logger logger = Logger.getLogger(PropertyUtil.class);

    private static Properties props;
    public static String getPropValue(String key) {
        DefaultResourceLoader loader=new DefaultResourceLoader();
        Resource resource=loader.getResource("classpath:local-env.properties");
        if(props==null){
            try {
                props = PropertiesLoaderUtils.loadProperties(resource);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        return  props.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println("------------------------>"+PropertyUtil.getPropValue("sss"));
    }
}
