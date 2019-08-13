package ink.lucien.aliyun.service.log;

import ink.lucien.aliyun.service.log.logger.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AliyunLogServiceMain {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new BufferedInputStream(new FileInputStream("src/main/resources/aliyun.service.log.properties"));
        Properties properties = new Properties();
        properties.load(inputStream);

        // 各个字段的含义见 https://help.aliyun.com/document_detail/29068.html
        String endpoint = properties.getProperty("endpoint");
        String accessKeyId = properties.getProperty("accessKeyId");
        String accessKeySecret =  properties.getProperty("accessKeySecret");
        String project = properties.getProperty("project");
        String logStore = properties.getProperty("logStore");

        Logger logger = new Logger(endpoint, accessKeyId, accessKeySecret, project, logStore);
        logger.write("BotOSSAdminServicerProvider", "Log Message Test");
    }
}
