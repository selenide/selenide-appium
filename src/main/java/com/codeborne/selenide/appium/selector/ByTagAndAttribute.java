package com.codeborne.selenide.appium.selector;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class ByTagAndAttribute extends By.ByXPath{

  protected final String tag;
  protected final String attributeName;
  protected final String attributeValue;

  public ByTagAndAttribute(String tag, String attributeName, String attributeValue) {
    super(".//" + tag + "[@" + attributeName +"=" + Quotes.escape(attributeValue) + "]");
    this.tag = tag;
    this.attributeName = attributeName;
    this.attributeValue = attributeValue;
  }

  @Override
  @CheckReturnValue
  @Nonnull
  public String toString() {
    return "by tag: " + tag + "; by attribute: " + attributeName + "; by value: " + attributeValue;
  }

  @CheckReturnValue
  @Nonnull
  String getXPath() {
    return super.toString().replace("By.xpath: ", "");
  }
}
