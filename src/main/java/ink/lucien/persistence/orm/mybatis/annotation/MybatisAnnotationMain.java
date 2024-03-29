package ink.lucien.persistence.orm.mybatis.annotation;

import java.io.IOException;
import java.io.InputStream;

import ink.lucien.persistence.orm.mybatis.annotation.mapper.KVSystemMapper;
import ink.lucien.persistence.orm.mybatis.annotation.model.KVSystem;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisAnnotationMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(KVSystemMapper.class);
        SqlSession session = sqlSessionFactory.openSession();

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
}
