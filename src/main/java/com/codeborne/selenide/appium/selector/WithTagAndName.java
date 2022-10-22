package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class WithTagAndName extends WithTagAndAttribute {

  public WithTagAndName(String tag, String nameAttributeValue) {
    super(tag, "name", nameAttributeValue);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by tag: " + tag + "; with name: " + attributeValue;
  }

  @Override
  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
