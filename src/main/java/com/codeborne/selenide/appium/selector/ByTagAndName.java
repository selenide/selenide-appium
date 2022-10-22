package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByTagAndName extends ByTagAndAttribute {

  public ByTagAndName(String tag, String attributeValue) {
    super(tag, "name", attributeValue);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
