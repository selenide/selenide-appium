package com.codeborne.selenide.appium.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import com.codeborne.selenide.appium.AppiumSetValueOptions;
import com.codeborne.selenide.commands.SetValue;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.appium.WebdriverUnwrapper.isMobile;
import static com.codeborne.selenide.commands.Util.firstOf;
import static java.util.Objects.requireNonNull;

@ParametersAreNonnullByDefault
public class AppiumSetValue implements Command<SelenideElement> {
  private final SetValue defaultImplementation = new SetValue();

  @Nonnull
  @Override
  public SelenideElement execute(SelenideElement proxy, WebElementSource locator, @Nullable Object[] args) {
    if (isMobile(locator.driver())) {
      WebElement element = locator.findAndAssertElementIsInteractable();
      AppiumSetValueOptions appiumSetValueOptions = extractOptions(requireNonNull(args));

      CharSequence text = requireNonNull(appiumSetValueOptions.value());
      element.clear();
      element.sendKeys(text);

      if (appiumSetValueOptions.shouldHideKeyboard()) {
        hideKeyBoard();
      }
      return proxy;
    } else {
      return defaultImplementation.execute(proxy, locator, args);
    }
  }

  private AppiumSetValueOptions extractOptions(Object[] args) {
    if (args[0] instanceof AppiumSetValueOptions) {
      return (AppiumSetValueOptions) args[0];
    } else {
      CharSequence text = firstOf(args);
      return AppiumSetValueOptions.withText(text);
    }
  }

  private void hideKeyBoard() {
    if (AppiumDriverRunner.isAndroidDriver() && AppiumDriverRunner.getAndroidDriver().isKeyboardShown()) {
      AppiumDriverRunner.getAndroidDriver().hideKeyboard();
    } else if (AppiumDriverRunner.isIosDriver() && AppiumDriverRunner.getIosDriver().isKeyboardShown()) {
      AppiumDriverRunner.getIosDriver().hideKeyboard();
    }
  }
}
