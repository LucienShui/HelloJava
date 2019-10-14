package ink.lucien.demo.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Model {

    private Long id;

    @Data
    public static class InnerModel {

        String name;
    }

    private InnerModel detail;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
