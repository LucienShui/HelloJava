package ink.lucien.persistence.orm.mybatis.xml.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MapMapper {
    int insert(@Param("data") Map<String, Object> map);
}
