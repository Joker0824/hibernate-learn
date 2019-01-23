package com.swx.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CurdTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void get() {
    new Curd().get();
  }


  @Test
  public void update() {
    new Curd().update();
  }

  @Test
  public void delete() {
    new Curd().delete();
  }

  @Test
  public void save() {
    new Curd().save();
  }
}
