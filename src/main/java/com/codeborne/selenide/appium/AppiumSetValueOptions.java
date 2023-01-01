package com.codeborne.selenide.appium;

public class AppiumSetValueOptions {

  private final CharSequence value;
  private boolean shouldHideKeyboard;

  private AppiumSetValueOptions(CharSequence value, boolean shouldHideKeyboard) {
    this.value = value;
    this.shouldHideKeyboard = shouldHideKeyboard;
  }

  public static AppiumSetValueOptions withText(CharSequence textToEnter) {
    return new AppiumSetValueOptions(textToEnter, false);
  }

  public void hideKeyboard() {
    this.shouldHideKeyboard = true;
  }

  public CharSequence value() {
    return value;
  }

  public boolean shouldHideKeyboard() {
    return shouldHideKeyboard;
  }

}
