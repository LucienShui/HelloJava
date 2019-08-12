package ink.lucien.persistent.orm.mybatis.xml.model;

public class KVSystem {

    public KVSystem(String key, String value) {
        setKey(key);
        setValue(value);
    }

    public String toString() {
        return "{\"" + key + "\":\"" + value + "\"}";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String key;
    private String value;
}
