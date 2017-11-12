package com.codeborne.selenide.appium;

import com.codeborne.selenide.SelenidePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenObject {
  /**
   * Create a Page Object instance.
   *
   * @param pageObject        A class which will be initialised
   * @param <PageObjectClass> PageObject class
   * @param <T>               Class of the PageObject
   * @return An instantiated instance of the class with SelenideElement and ElementsCollection fields proxied
   * @see PageFactory#initElements(WebDriver, Class)
   */
  public static <PageObjectClass, T extends PageObjectClass> PageObjectClass screen(T pageObject) {
    SelenidePageFactory.initElements(new SelenideAppiumFieldDecorator(getWebDriver()), pageObject);
    return pageObject;
  }
}
