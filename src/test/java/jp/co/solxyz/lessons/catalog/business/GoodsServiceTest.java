package jp.co.solxyz.lessons.catalog.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import jp.co.solxyz.lessons.catalog.entity.GoodsEntity;

public class GoodsServiceTest {

    private GoodsService target = new GoodsService();

    @Test
    public void testGetAllGoods() {

        List<GoodsEntity> list;

        try {
            list = target.getAllGoods();
            assertNotNull(list);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
