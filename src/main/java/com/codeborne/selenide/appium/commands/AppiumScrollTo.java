package com.codeborne.selenide.appium.commands;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ScrollTo;
import com.codeborne.selenide.impl.WebElementSource;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

import static com.codeborne.selenide.appium.WebdriverUnwrapper.cast;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;


@ParametersAreNonnullByDefault
public class AppiumScrollTo extends ScrollTo {

  private AppiumDriver appiumDriver;

  @Override
  @Nonnull
  public SelenideElement execute(SelenideElement proxy, WebElementSource locator, @Nullable Object[] args) {
    Optional<AppiumDriver> appiumDriverOptional = cast(locator.driver(), AppiumDriver.class);
    if (!appiumDriverOptional.isPresent()) {
      return super.execute(proxy, locator, args);
    }

    this.appiumDriver = appiumDriverOptional.get();

    String previousPageSource = "";
    while (isElementNotDisplayed(locator) && isNotEndOfPage(previousPageSource)) {
      previousPageSource = appiumDriver.getPageSource();
      performScroll();
    }
    return proxy;
  }

  private boolean isElementNotDisplayed(WebElementSource locator){
    try{
      return !locator.getWebElement().isDisplayed();
    }
    catch (NullPointerException | NoSuchElementException exception){
      return true;
    }
  }

  private boolean isNotEndOfPage(String initialPageSource){
    return !initialPageSource.equals(appiumDriver.getPageSource());
  }

  private Dimension getMobileDeviceSize() {
    return appiumDriver.manage().window().getSize();
  }

  private void performScroll(){
    Dimension size = getMobileDeviceSize();
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence sequenceToPerformScroll = getSequenceToPerformScroll(finger, size);
    appiumDriver.perform(singletonList(sequenceToPerformScroll));
  }

  private Sequence getSequenceToPerformScroll(PointerInput finger, Dimension size){
    return new Sequence(finger, 1)
      .addAction(finger.createPointerMove(ofMillis(0),
        PointerInput.Origin.viewport(), size.getWidth() / 2, size.getHeight() / 2))
      .addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
      .addAction(finger.createPointerMove(ofMillis(500),
        PointerInput.Origin.viewport(), size.getWidth() / 2, (int)(size.getHeight() * 0.25)))
      .addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
  }
}
