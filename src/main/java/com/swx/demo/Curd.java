package com.swx.demo;

import com.swx.entity.PersonEntity;
import com.swx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * 使用hibernate增删查改
 */
public class Curd {
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
  public void update() {
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
  public void delete() {
    Session session = HibernateUtil.openSession();
    Transaction transaction = session.beginTransaction();
    PersonEntity personEntity = session.get(PersonEntity.class, 2);
    session.delete(personEntity);
    transaction.commit();
    session.close();
  }

  public void save() {
    Session session = HibernateUtil.openSession();
    Transaction transaction = session.beginTransaction();
    //瞬时态对象,没有唯一的标识oid,没有被session管理(处理)
    PersonEntity personEntity = new PersonEntity();
    personEntity.setName("陈冠希");
    personEntity.setEmail("陈冠希的电子邮件");
    //持久态对象,有唯一的标识oid,被session管理
    Serializable saveSerializable = session.save(personEntity);
    System.out.println(saveSerializable);
    System.out.println(session.get(PersonEntity.class, saveSerializable));
    transaction.commit();
    session.close();
//    脱管态,有唯一的标识oid,脱离了session的管理
    System.out.println(personEntity);
  }

  /**
   * 通过query对象查询
   */
  public void query() {
    Session currentSession = HibernateUtil.getCurrentSession();
//    写实体类名
    Transaction transaction = currentSession.beginTransaction();
    String hql = "from PersonEntity where name like ?";
//    String hql = "from PersonEntity";
    Query query = currentSession.createQuery(hql);
    query.setParameter(0,"陈%");
    List<PersonEntity> list = query.list();
    for (PersonEntity p : list) {
      System.out.println(p);
    }
    transaction.commit();
  }

  /**
   * 一级缓存快照区
   */
  public void demo1() {
    Session session = HibernateUtil.openSession();
    Transaction transaction = session.beginTransaction();
    PersonEntity personEntity = session.get(PersonEntity.class, 16);
    personEntity.setAddress("香港");
    System.out.println(personEntity);
    transaction.commit();
    session.close();
  }

  public void demo2() {
    Session session = HibernateUtil.getCurrentSession();
    Transaction transaction = session.beginTransaction();
    PersonEntity personEntity = session.get(PersonEntity.class, 16);
    personEntity.setAddress("Hongkong");
    transaction.commit();
//    绑定了当前线程,不用关闭session
    session.close();
  }
}
