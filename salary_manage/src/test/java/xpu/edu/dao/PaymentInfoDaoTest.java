package xpu.edu.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xpu.edu.entry.GrantItem;
import xpu.edu.entry.PaymentInfo;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PaymentInfoDaoTest {
    @Test
    public void getAllTest() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("resource.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        PaymentInfoDao mapper = session.getMapper(PaymentInfoDao.class);
        List<PaymentInfo> all = mapper.getAll();
        for (PaymentInfo pay:all) {
            System.out.println(pay);
        }
        session.commit();
        session.close();
    }
}
