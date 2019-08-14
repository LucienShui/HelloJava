package ink.lucien.persistence.orm.mybatis.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import ink.lucien.persistence.orm.mybatis.xml.mapper.KVSystemMapper;
import ink.lucien.persistence.orm.mybatis.xml.mapper.MapMapper;
import ink.lucien.persistence.orm.mybatis.xml.model.KVSystem;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisXMLMain {
    private static void mapTest(SqlSession session) {
        MapMapper mapMapper = session.getMapper(MapMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("__string", "Hello World!");
        map.put("__int", 10086);
        map.put("__double", 3.14159);

        mapMapper.insert(map);
        session.commit();
    }

    private static void kvSystemTest(SqlSession session) {
        KVSystemMapper kvSystemMapper = session.getMapper(KVSystemMapper.class);

        KVSystem kvSystem = new KVSystem("Hello", "World!");

        kvSystemMapper.insert(kvSystem);
        session.commit();

        kvSystem = kvSystemMapper.getValueByKey("Hello");
        System.out.println(kvSystem + " inserted");

        kvSystem.setValue("Mybatis!");
        kvSystemMapper.updateExistRecord(kvSystem);
        session.commit();

        kvSystem = kvSystemMapper.getValueByKey("Hello");
        System.out.println("After updating: " + kvSystem);

        kvSystemMapper.deleteByKey("Hello");
        session.commit();
        System.out.println("\"Hello\" deleted");

    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        kvSystemTest(session);
        mapTest(session);
    }
}
