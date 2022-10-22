package com.codeborne.selenide.appium;

import com.codeborne.selenide.appium.selector.*;
import org.openqa.selenium.By;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class AppiumSelectors {

  private AppiumSelectors(){
  }

  @CheckReturnValue
  @Nonnull
  public static By byTagAndText(String tag, String elementText) {
    return new ByTagAndText(tag, elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By byText(String elementText) {
    return new ByText(elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By withTagAndText(String tag, String elementText) {
    return new WithTagAndText(tag, elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By withText(String elementText) {
    return new WithText(elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By byTagAndName(String tag, String elementText) {
    return new ByTagAndName(tag, elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By byName(String elementText) {
    return new ByName(elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By withTagAndName(String tag, String elementText) {
    return new WithTagAndName(tag, elementText);
  }

  @CheckReturnValue
  @Nonnull
  public static By withName(String elementText) {
    return new WithName(elementText);
  }

}
