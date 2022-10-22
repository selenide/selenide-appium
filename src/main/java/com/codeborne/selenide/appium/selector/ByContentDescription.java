package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByContentDescription extends ByTagAndContentDescription{

  public ByContentDescription(String contentDescriptionValue) {
    super("*", contentDescriptionValue);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
