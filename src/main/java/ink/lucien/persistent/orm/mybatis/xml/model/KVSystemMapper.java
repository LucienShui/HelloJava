package ink.lucien.persistent.orm.mybatis.xml.model;

public interface KVSystemMapper {
    void insert(KVSystem kvSystem);

    void deleteByKey(String key);

    void updateExistRecord(KVSystem key);

    KVSystem getValueByKey(String key);
}
