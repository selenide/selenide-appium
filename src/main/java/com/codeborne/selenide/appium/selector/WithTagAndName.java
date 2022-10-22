package com.codeborne.selenide.appium.selector;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class WithTagAndName extends By.ByXPath {

  protected final String tag;
  protected final String elementNameAttribute;

  public WithTagAndName(String tag, String elementNameAttribute) {
    super(".//" + tag + "[contains(@name," + Quotes.escape(elementNameAttribute) + ")]");
    this.tag = tag;
    this.elementNameAttribute = elementNameAttribute;
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by tag: " + tag + "; with name: " + elementNameAttribute;
  }

  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
