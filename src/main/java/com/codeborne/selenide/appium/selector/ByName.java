package com.codeborne.selenide.appium.selector;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByName extends ByTagAndName{

  public ByName(String elementNameAttribute) {
    super("*", elementNameAttribute);
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by name: " + elementNameAttribute;
  }
}
