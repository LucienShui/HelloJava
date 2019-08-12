package ink.lucien.persistent.orm.mybatis.xml;

import java.io.IOException;
import java.io.InputStream;

import ink.lucien.persistent.orm.mybatis.xml.model.KVSystem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        KVSystem kvSystem = session.selectOne("getValueByKey", "Hello");
        System.out.printf("%s %s\n", kvSystem.getKey(), kvSystem.getValue());
    }
}
