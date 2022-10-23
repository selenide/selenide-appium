package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class WithTagAndText extends WithTagAndAttribute {

  public WithTagAndText(String tag, String elementText) {
    super(tag, "text", elementText);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by tag: " + tag + "; with text: " + attributeValue;
  }
}
