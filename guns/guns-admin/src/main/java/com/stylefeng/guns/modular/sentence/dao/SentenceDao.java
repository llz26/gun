package com.stylefeng.guns.modular.sentence.dao;

import com.stylefeng.guns.modular.sentence.Domain.Sentence;
import com.stylefeng.guns.modular.vocabulary.dao.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SentenceDao {
    //查询hsk表
    public List<Sentence> getSenList(int type){
        Transaction tx = null;
        String hql;
        try{
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            hql = "from Sentence s where s.type=?";
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(0,type);
            List<Sentence> list = query.list();
            tx.commit();
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(tx!=null){
                tx=null;
            }
        }
    }
}
