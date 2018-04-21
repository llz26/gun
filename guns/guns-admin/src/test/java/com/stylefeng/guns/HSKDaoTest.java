package com.stylefeng.guns;

import com.stylefeng.guns.modular.vocabulary.dao.HSKDao;
import org.junit.Test;

public class HSKDaoTest {
    @Test
    public void testHSKDao(){
        HSKDao hskDao = new HSKDao();
        System.out.print(hskDao.getHSKList(1).get(1).getWord());
    }
}
