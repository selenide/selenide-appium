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
      .hasToString("by tag: *; by attribute: name; by value: selen'ide-app'ium");
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
    By by = AppiumSelectors.withName("selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("with name: selen'ide-app'ium");
  }

  @Test
  void testByTagAndAttributeSelector(){
    By by = AppiumSelectors.byTagAndAttribute("*","text","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: text; by value: selen'ide-app'ium");
  }

  @Test
  void testByAttributeSelector(){
    By by = AppiumSelectors.byAttribute("text","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: text; by value: selen'ide-app'ium");
  }

  @Test
  void testWithTagAndAttributeSelector(){
    By by = AppiumSelectors.withTagAndAttribute("*","text","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: text; with value: selen'ide-app'ium");
  }

  @Test
  void testWithAttributeSelector(){
    By by = AppiumSelectors.withAttribute("text","selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: text; with value: selen'ide-app'ium");
  }

  @Test
  void testByTagAndContentDescriptionSelector(){
    By by = AppiumSelectors.byTagAndContentDescription("*", "selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: content-desc; by value: selen'ide-app'ium");
  }

  @Test
  void testWithTagAndContentDescriptionSelector(){
    By by = AppiumSelectors.withTagAndContentDescription("*", "selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: content-desc; with value: selen'ide-app'ium");
  }

  @Test
  void testByContentDescriptionSelector(){
    By by = AppiumSelectors.byContentDescription( "selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: content-desc; by value: selen'ide-app'ium");
  }

  @Test
  void testWithContentDescriptionSelector(){
    By by = AppiumSelectors.withContentDescription("selen'ide-app'ium");
    assertThat(by)
      .isInstanceOf(By.ByXPath.class)
      .hasToString("by tag: *; by attribute: content-desc; with value: selen'ide-app'ium");
  }
}
