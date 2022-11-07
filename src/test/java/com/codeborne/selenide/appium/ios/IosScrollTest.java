package com.codeborne.selenide.appium.ios;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.$;

@ExtendWith(TextReportExtension.class)
class IosScrollTest {

  @Test
  void testScrollToElementOnIos() {
    closeWebDriver();
    Configuration.browser = IosTestAppDriverFactory.class.getName();
    Configuration.browserSize = null;
    WebDriverRunner.addListener(new AbstractWebDriverEventListener() {
    });
    open();

    $(By.xpath("//*[@name='Test Gesture']"))
      .shouldBe(visible)
      .click();
    $(By.xpath("//*[contains(@name,'Ocean')]"))
      .scrollTo()
      .shouldHave(text("Indian Ocean"));
  }
}
