package ink.lucien.persistence.orm.mybatis.annotation.mapper;

import ink.lucien.persistence.orm.mybatis.annotation.model.KVSystem;
import org.apache.ibatis.annotations.*;

public interface KVSystemMapper {
    @Insert("INSERT INTO `kv_system` (`key`, `value`) VALUES (#{key}, #{value})")
    void insert(KVSystem kvSystem);

    @Delete("DELETE FROM `kv_system` WHERE `key` = #{key}")
    void deleteByKey(@Param("key") String key);

    @Update("UPDATE `kv_system` SET `value` = #{value} WHERE `key` = #{key}")
    void updateExistRecord(KVSystem key);

    @Select("SELECT * FROM `kv_system` WHERE `key` = #{key}")
    KVSystem getValueByKey(@Param("key") String key);
}
