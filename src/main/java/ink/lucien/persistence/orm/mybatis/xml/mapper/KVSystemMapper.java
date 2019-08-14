package ink.lucien.persistence.orm.mybatis.xml.mapper;

import ink.lucien.persistence.orm.mybatis.xml.model.KVSystem;

public interface KVSystemMapper {
    void insert(KVSystem kvSystem);

    void deleteByKey(String key);

    void updateExistRecord(KVSystem key);

    KVSystem getValueByKey(String key);
}
