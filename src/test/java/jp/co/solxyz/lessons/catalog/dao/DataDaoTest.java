package jp.co.solxyz.lessons.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import jp.co.solxyz.lessons.catalog.entity.InquiryEntity;

public class DataDaoTest {

    private DataDao target;

    @Test
    public void readTest() {

        try{ 

            target = new DataDao();

            var retList = target.select("select * from goods");

            assertEquals(retList.size(), 1);
            assertEquals(retList.get(0).getId(), 1);
            
        }catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void insertTest() {

        try{

            target = new DataDao();

            InquiryEntity entity = new InquiryEntity();

            entity.setName("name");
            entity.setCompany("company");
            entity.setMail("mail@mail.com");

            int result = target.insert(entity);

            assertEquals(result, 1);

        }catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
