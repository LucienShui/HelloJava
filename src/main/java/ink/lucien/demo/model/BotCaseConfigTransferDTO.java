package ink.lucien.demo.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Lucien on 2019/10/18 14:51
 */
@Data
public class BotCaseConfigTransferDTO {

    private List<String> queueIdList;

    private List<String> groupIdList;

    private String groupId;
}
