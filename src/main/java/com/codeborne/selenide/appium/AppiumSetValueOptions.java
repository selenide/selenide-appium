package com.codeborne.selenide.appium;

import com.codeborne.selenide.SetValueMethod;
import com.codeborne.selenide.SetValueOptions;

public class AppiumSetValueOptions extends SetValueOptions {

  private boolean shouldHideKeyboard;

  private AppiumSetValueOptions(CharSequence value, boolean shouldHideKeyboard) {
    super(SetValueMethod.SEND_KEYS, value, value);
    this.shouldHideKeyboard = shouldHideKeyboard;
  }

  public static AppiumSetValueOptions withText(CharSequence textToEnter) {
    return new AppiumSetValueOptions(textToEnter, false);
  }

  public AppiumSetValueOptions hideKeyboard() {
    this.shouldHideKeyboard = true;
    return this;
  }

  public boolean shouldHideKeyboard() {
    return shouldHideKeyboard;
  }

}
