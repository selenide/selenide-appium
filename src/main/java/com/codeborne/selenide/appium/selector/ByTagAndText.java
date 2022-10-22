package com.codeborne.selenide.appium.selector;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByTagAndText extends By.ByXPath {

  protected final String tag;
  protected final String elementText;

  public ByTagAndText(String tag, String elementText) {
    super(".//" + tag + "[@text=" + Quotes.escape(elementText) + "]");
    this.tag = tag;
    this.elementText = elementText;
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by tag: " + tag + "; by text: " + elementText;
  }

  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
