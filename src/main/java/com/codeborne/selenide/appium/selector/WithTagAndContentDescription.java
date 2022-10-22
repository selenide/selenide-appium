package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class WithTagAndContentDescription extends WithTagAndAttribute{

  public WithTagAndContentDescription(String tag, String contentDescriptionValue) {
    super(tag, "content-desc", contentDescriptionValue);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
