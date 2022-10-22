package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByAttribute extends ByTagAndAttribute{

  public ByAttribute(String attributeName, String attributeValue) {
    super("*", attributeName, attributeValue);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
