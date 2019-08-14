package ink.lucien.aliyun.service.log.logger;

import com.aliyun.openservices.log.Client;
import com.aliyun.openservices.log.request.PutLogsRequest;
import java.util.Vector;
import com.aliyun.openservices.log.common.LogItem;

public class Logger {
    private Client client;
    private String project;
    private String logStore;

    public Logger(String endpoint, String accessKeyId, String accessKeySecret, String project, String logStore) {
        this.project = project;
        this.logStore = logStore;

        client = new Client(endpoint, accessKeyId, accessKeySecret);
    }

    public void write(String key, String value) throws Exception {
        String topic = "";
        String source = "";
        Vector<LogItem> logGroup = new Vector<>();
        LogItem logItem = new LogItem((int) (System.currentTimeMillis() / 1000));
        logItem.PushBack(key, value);
        logGroup.add(logItem);
        PutLogsRequest req2 = new PutLogsRequest(project, logStore, topic, source, logGroup);
        client.PutLogs(req2);
    }
}
