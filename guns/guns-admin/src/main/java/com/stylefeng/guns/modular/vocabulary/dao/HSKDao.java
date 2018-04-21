package com.stylefeng.guns.modular.vocabulary.dao;

import com.stylefeng.guns.modular.vocabulary.Domain.HSK;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HSKDao {
    //查询hsk表
    public List<HSK> getHSKList(int level) {
        Transaction tx = null;
        String hql;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            hql = "from HSK s where s.level=?";
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(0, level);
            List<HSK> list = query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }

    // 根据id从HSK中删除一条记录
    public boolean deleteHSKById(int id) {
        Transaction tx = null;
        String hql;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            hql = "delete from HSK s where s.id=?";
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(0, id);
            query.executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }

    // 添加一条数据到HSK
    public boolean insertHSK(HSK hsk) {
        Transaction tx = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(hsk);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }
}
