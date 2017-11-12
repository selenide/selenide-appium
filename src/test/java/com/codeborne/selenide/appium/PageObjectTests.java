package com.codeborne.selenide.appium;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class PageObjectTests extends BaseTest {
  private final CalculatorPage calculatorPage = new CalculatorPage();

  @Test
  public void pageObject() {
    screen(calculatorPage);
    calculatorPage.number2.click();
    calculatorPage.plus.click();
    calculatorPage.number4.click();
    calculatorPage.equal.click();
    calculatorPage.result.shouldHave(text("6"));
  }
}
