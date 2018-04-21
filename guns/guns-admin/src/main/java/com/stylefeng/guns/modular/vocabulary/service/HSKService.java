package com.stylefeng.guns.modular.vocabulary.service;

import com.stylefeng.guns.modular.vocabulary.Domain.HSK;
import com.stylefeng.guns.modular.vocabulary.dao.HSKDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HSKService {
    private HSKDao hskDao;

    @Autowired
    public void setHskDao(HSKDao hskDao) {
        this.hskDao = hskDao;
    }
    public List<HSK> getHSKList(int level){return hskDao.getHSKList(level);}
    public boolean deleteHSKById(int id){return hskDao.deleteHSKById(id);}
    public boolean insertHSK(HSK hsk){return hskDao.insertHSK(hsk);}
}
