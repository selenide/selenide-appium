package com.codeborne.selenide.appium.demos;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.AppiumSelectors.byTagAndAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.byTagAndContentDescription;
import static com.codeborne.selenide.appium.AppiumSelectors.byTagAndText;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.AppiumSelectors.withAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.withContentDescription;
import static com.codeborne.selenide.appium.AppiumSelectors.withTagAndAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.withTagAndContentDescription;
import static com.codeborne.selenide.appium.AppiumSelectors.withTagAndText;
import static com.codeborne.selenide.appium.AppiumSelectors.withText;

class AndroidSelectorsTest extends AbstractApiDemosTest {

  private static final String VIEWS = "Views";
  private static final String GRAPHICS_PARTIAL_STRING = "Graphi";

  @Test
  void testAppiumSelectorsInAndroidApp() {
    $(byAttribute("content-desc", VIEWS)).click();
    pressBack();
    $(byContentDescription(VIEWS)).click();
    pressBack();
    $(byTagAndAttribute("*", "text", VIEWS)).click();
    pressBack();
    $(byTagAndContentDescription("*", VIEWS)).click();
    pressBack();
    $(byTagAndText("*", VIEWS)).click();
    pressBack();
    $(byText(VIEWS)).click();
    pressBack();
    $(withAttribute("text", GRAPHICS_PARTIAL_STRING)).click();
    pressBack();
    $(withContentDescription(GRAPHICS_PARTIAL_STRING)).click();
    pressBack();
    $(withTagAndAttribute("*", "text", GRAPHICS_PARTIAL_STRING)).click();
    pressBack();
    $(withTagAndContentDescription("*", GRAPHICS_PARTIAL_STRING)).click();
    pressBack();
    $(withTagAndText("android.widget.TextView", GRAPHICS_PARTIAL_STRING)).click();
    pressBack();
    $(withText(GRAPHICS_PARTIAL_STRING))
      .shouldHave(text("Graphics"));
  }

  private void pressBack() {
    WebDriverRunner.getWebDriver().navigate().back();
  }
}
