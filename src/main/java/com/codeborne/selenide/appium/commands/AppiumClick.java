package com.codeborne.selenide.appium.commands;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Command;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.WebElement;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.visible;
import static java.util.Objects.requireNonNull;

@ParametersAreNonnullByDefault
public class AppiumClick implements Command<Void> {
  @Override
  @Nullable
  public Void execute(SelenideElement proxy, WebElementSource locator, @Nullable Object[] args) {
    Driver driver = locator.driver();
    if (driver.config().clickViaJs()) {
      throw new IllegalArgumentException("Click via JS is not supported in selenide-appium");
    }

    WebElement webElement = requireNonNull(locator.checkCondition("", visible, false));
    if (args == null || args.length == 0) {
      webElement.click();
    }
    else if (args.length == 1) {
      ClickOptions clickOptions = (ClickOptions) args[0];
      click(driver, webElement, clickOptions);
    }
    else if (args.length == 2) {
      Integer offsetX = (Integer) args[0];
      Integer offsetY = (Integer) args[1];
      click(driver, webElement, offsetX, offsetY);
    }
    return null;
  }

  // should be removed after deleting SelenideElement.click(int offsetX, int offsetY);
  private void click(Driver driver, WebElement element, int offsetX, int offsetY) {
    driver.actions()
      .moveToElement(element, offsetX, offsetY)
      .click()
      .build()
      .perform();
  }

  private void click(Driver driver, WebElement webElement, ClickOptions clickOptions) {
    switch (clickOptions.clickOption()) {
      case DEFAULT: {
        defaultClick(driver, webElement, clickOptions.offsetX(), clickOptions.offsetY());
        break;
      }
      case JS: {
        throw new IllegalArgumentException("Click via JS is not supported in selenide-appium");
      }
      default: {
        throw new IllegalArgumentException("Unknown click option: " + clickOptions.clickOption());
      }
    }
  }

  private void defaultClick(Driver driver, WebElement element, int offsetX, int offsetY) {
    driver.actions()
      .moveToElement(element, offsetX, offsetY)
      .click()
      .perform();
  }
}
