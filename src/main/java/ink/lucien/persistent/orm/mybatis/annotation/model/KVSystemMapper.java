package ink.lucien.persistent.orm.mybatis.annotation.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface KVSystemMapper {
    @Insert("INSERT INTO `kv_system` (`key`, `value`) VALUES (#{key}, #{value})")
    void insert(KVSystem kvSystem);

    @Delete("DELETE FROM `kv_system` WHERE `key` = #{key}")
    void deleteByKey(String key);

    @Update("UPDATE `kv_system` SET `value` = #{value} WHERE `key` = #{key}")
    void updateExistRecord(KVSystem key);

    @Select("SELECT * FROM `kv_system` WHERE `key` = #{key}")
    KVSystem getValueByKey(String key);
}
