package watchService;

import org.apache.log4j.helpers.FileWatchdog;

/**
 * 使用log4j的watchDog监控文件内容的变化
 * 修改完 ctrl + s
 */
public class Log4jWatchdog {
    public static void main(String[] args) {
        GloablConfig gloablConfig = new GloablConfig("/Users/yejunjie/project/yjj/basic/basic-service/src/main/java/watchService/config.txt");

        gloablConfig.setDelay(100);
        gloablConfig.start();
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    public static class GloablConfig extends FileWatchdog {
        protected GloablConfig(String filename) {
            super(filename);
        }

        @Override
        protected void doOnChange() {
            System.out.println(filename);
        }

    }
}
