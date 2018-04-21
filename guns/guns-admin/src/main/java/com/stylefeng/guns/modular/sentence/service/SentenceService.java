package com.stylefeng.guns.modular.sentence.service;

import com.stylefeng.guns.modular.sentence.Domain.Sentence;
import com.stylefeng.guns.modular.sentence.dao.SentenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentenceService {
    private SentenceDao sentenceDao;

    @Autowired
    public void setHskDao(SentenceDao sentenceDao) {
        this.sentenceDao = sentenceDao;
    }
    public List<Sentence> getSenList(int type){return sentenceDao.getSenList(type);}
}
