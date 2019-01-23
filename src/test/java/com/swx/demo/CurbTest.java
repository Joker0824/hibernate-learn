package com.swx.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurbTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void get() {
    new Curb().get();
  }


  @Test
  public void update() {
    new Curb().update();
  }

  @Test
  public void delete() {
    new Curb().delete();
  }
}
