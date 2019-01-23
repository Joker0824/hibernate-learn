package com.swx.demo;

import com.swx.entity.PersonEntity;
import com.swx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 使用hibernate增删查改
 */
public class Curb {
  /**
   * 查找
   */
  public void get() {
    Session session = HibernateUtil.openSession();
//      开始事务
    Transaction transaction = session.beginTransaction();
//      提交事务
    PersonEntity personEntity = session.get(PersonEntity.class, 2);
    System.out.println(personEntity);
    transaction.commit();
//    关闭连接
    session.close();
  }

  /**
   * 更新
   */
  public void update(){
    Session session = HibernateUtil.openSession();
    Transaction transaction = session.beginTransaction();
    PersonEntity personEntity = session.get(PersonEntity.class, 1);
    personEntity.setName("离婚后的杨幂");
    session.update(personEntity);
    transaction.commit();
    session.close();

  }

  /**
   * 删除
   */
  public void delete(){
    Session session = HibernateUtil.openSession();
    Transaction transaction = session.beginTransaction();
    PersonEntity personEntity = session.get(PersonEntity.class, 2);
    session.delete(personEntity);
    transaction.commit();
    session.close();
  }
}
