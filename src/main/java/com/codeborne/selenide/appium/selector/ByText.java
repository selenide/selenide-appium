package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByText extends ByTagAndText{

  public ByText(String elementText) {
    super("*", elementText);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by text: " + attributeValue;
  }
}
