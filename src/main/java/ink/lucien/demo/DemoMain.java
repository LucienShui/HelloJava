package ink.lucien.demo;

import com.alibaba.fastjson.JSON;
import ink.lucien.demo.model.BotCaseConfigTransferDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DemoMain {

    public static void main(String[] args) {
        String jsonString = "[{\"groupId\": \"1769001\", \"groupIdList\": [\"123\",\"234\"], \"queueIdList\": [\"20190517\"]}]";

        List<BotCaseConfigTransferDTO> botCaseConfigTransferDTOList =
                JSON.parseArray(jsonString).toJavaList(BotCaseConfigTransferDTO.class);

        for (BotCaseConfigTransferDTO each : botCaseConfigTransferDTOList) {
            System.out.println(each.getGroupId());
            System.out.println(each.getGroupIdList().stream().map(Long::valueOf).collect(Collectors.toList()));
            System.out.println(each.getQueueIdList());
        }
    }
}
