package xpu.edu.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xpu.edu.entry.GrantItem;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class GrantItemDaoTest {
    @Test
    public void addOne() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("resource.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        GrantItemDao mapper = session.getMapper(GrantItemDao.class);

        GrantItem grantItem = new GrantItem();
        grantItem.setGrant_id(111112);
        grantItem.setUser_id("黎红丽");
        grantItem.setPayment_item_id("123456789");
        grantItem.setSalary_id("00000");

        mapper.addOne(grantItem);

        session.commit();
        session.close();
    }


    @Test
    public void test() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("resource.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        GrantItemDao mapper = session.getMapper(GrantItemDao.class);
        List<GrantItem> all = mapper.getAll();
        for (GrantItem grantItem:all) {
            System.out.println(grantItem);
        }
        session.commit();
        session.close();
    }

    @Test
    public void deleteOne() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("resource.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        GrantItemDao mapper = session.getMapper(GrantItemDao.class);
        mapper.deleteOne(11111);
        session.commit();
        session.close();
    }

    @Test
    public void updateOne() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("resource.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        GrantItemDao mapper = session.getMapper(GrantItemDao.class);

        GrantItem grantItem = new GrantItem();
        grantItem.setGrant_id(111112);
        grantItem.setUser_id("黎红丽");
        grantItem.setPayment_item_id("123456789");
        grantItem.setSalary_id("00000");

        mapper.updateOne(grantItem);
        session.commit();
        session.close();
    }
}
