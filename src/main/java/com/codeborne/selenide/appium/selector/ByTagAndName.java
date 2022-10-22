package com.codeborne.selenide.appium.selector;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByTagAndName extends By.ByXPath {

  protected final String tag;
  protected final String elementNameAttribute;

  public ByTagAndName(String tag, String elementNameAttribute) {
    super(".//" + tag + "[@name=" + Quotes.escape(elementNameAttribute) + "]");
    this.tag = tag;
    this.elementNameAttribute = elementNameAttribute;
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by tag: " + tag + "; by name: " + elementNameAttribute;
  }

  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
