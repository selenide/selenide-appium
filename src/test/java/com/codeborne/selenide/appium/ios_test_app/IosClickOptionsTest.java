package com.codeborne.selenide.appium.ios_test_app;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.AppiumClickOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class IosClickOptionsTest extends IosAppBaseTestUp {

  @Test
  void testIosTap(){
    $(By.name("IntegerA")).sendKeys("3");
    $(By.name("IntegerB")).sendKeys("3");
    $(By.name("ComputeSumButton")).click(AppiumClickOptions.tap());
    $(By.name("Answer")).shouldHave(Condition.text("6"));
  }
}