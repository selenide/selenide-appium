package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class WithText extends WithTagAndText {
  public WithText(String elementText) {
    super("*", elementText);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "with text: " + attributeValue;
  }
}
