package com.swx.demo;

import com.swx.entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class Demo {

  public void testDemo(){
    PersonEntity personEntity = new PersonEntity();
    personEntity.setName("joker");
    personEntity.setEmail("314231258@qq.com");
    //获取加载配置文件的管理类对象,默认加载src/hibernate.cfg.xml文件
    Configuration config=new Configuration().configure("hibernate.cfg.xml");
    //创建session的工厂文件
    SessionFactory sf=config.buildSessionFactory();
    //创建session（代表一个会话，与数据库连接的会话）
    Session session=sf.openSession();
    //开启事务
    Transaction tx=session.beginTransaction();
    //保存到数据库
    Serializable serializableSave = session.save(personEntity);
    System.out.println(serializableSave);
    //提交事务
    tx.commit();
    //关闭
    session.close();
    //sessionFactory关闭
    sf.close();
  }
}
