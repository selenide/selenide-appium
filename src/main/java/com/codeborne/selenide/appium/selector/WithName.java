package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class WithName extends WithTagAndName {
    public WithName(String elementNameAttribute) {
    super("*", elementNameAttribute);
    }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by text: " + elementNameAttribute;
  }
}
