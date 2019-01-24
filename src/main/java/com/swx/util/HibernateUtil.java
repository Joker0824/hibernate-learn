package com.swx.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
  public static final Configuration configuration;
  public static final SessionFactory sessionFactory;

  static {
    configuration = new Configuration().configure("hibernate.cfg.xml");
    sessionFactory = configuration.buildSessionFactory();
  }

  public static Session openSession() {
    return sessionFactory.openSession();
  }

  /**
   * @return 获取当前线程绑定的session
   */
  public static Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }
}
