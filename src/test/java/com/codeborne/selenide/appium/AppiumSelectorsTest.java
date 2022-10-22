package com.codeborne.selenide.appium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

class AppiumSelectorsTest {

  @Test
  void testByTagAndTextSelector(){
    By by = AppiumSelectors.byTagAndText("*","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by text: selen'ide-app'ium");
  }

  @Test
  void testByTextSelector(){
    By by = AppiumSelectors.byText("selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by text: selen'ide-app'ium");
  }

  @Test
  void testWithTagAndTextSelector(){
    By by = AppiumSelectors.withTagAndText("*","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; with text: selen'ide-app'ium");
  }

  @Test
  void testWithTextSelector(){
    By by = AppiumSelectors.withText("selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("with text: selen'ide-app'ium");
  }

  @Test
  void testByTagAndNameSelector(){
    By by = AppiumSelectors.byTagAndName("*","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by name: selen'ide-app'ium");
  }

  @Test
  void testByNameSelector(){
    By by = AppiumSelectors.byName("selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by name: selen'ide-app'ium");
  }

  @Test
  void testWithTagAndNameSelector(){
    By by = AppiumSelectors.withTagAndName("*","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; with name: selen'ide-app'ium");
  }

  @Test
  void testWithNameSelector(){
    By by = AppiumSelectors.byName("selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("with name: selen'ide-app'ium");
  }
}
