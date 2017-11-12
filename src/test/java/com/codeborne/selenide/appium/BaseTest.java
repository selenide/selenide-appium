package com.codeborne.selenide.appium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.provider.LocalAndroidDriverProvider;
import com.codeborne.selenide.appium.provider.RemoteAndroidDriverProvider;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.close;

public class BaseTest {
  private static final String LOCAL = System.getProperty("local", "true");

  @Before
  public void setUp() {
    boolean local = Boolean.parseBoolean(LOCAL);
    Configuration.browser = local
      ? LocalAndroidDriverProvider.class.getName()
      : RemoteAndroidDriverProvider.class.getName();
  }

  @After
  public void tearDown() {
    close();
  }
}
