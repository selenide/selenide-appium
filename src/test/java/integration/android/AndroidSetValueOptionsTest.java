package integration.android;

import com.codeborne.selenide.appium.AppiumClickOptions;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import com.codeborne.selenide.appium.AppiumSetValueOptions;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

class AndroidSetValueOptionsTest extends BaseSwagLabsAndroidTest {

  @Test
  void testHideKeyboardForAndroid() {
    SelenideAppium.openAndroidDeepLink("mydemoapprn://login", "com.saucelabs.mydemoapp.rn");
    $(AppiumBy.accessibilityId("Username input field"))
      .shouldBe(visible)
      .click(AppiumClickOptions.tap())
      .setValue(AppiumSetValueOptions.withText("abcd").hideKeyboard());

    assertThat(AppiumDriverRunner.getAndroidDriver().isKeyboardShown())
      .isFalse();

    $(AppiumBy.accessibilityId("Username input field")).shouldHave(text("abcd"));
  }

  @Test
  void testSetValueOptionsForAndroid() {
    SelenideAppium.openAndroidDeepLink("mydemoapprn://login", "com.saucelabs.mydemoapp.rn");
    $(AppiumBy.accessibilityId("Username input field"))
      .shouldBe(visible)
      .click(AppiumClickOptions.tap())
      .setValue(AppiumSetValueOptions.withText("abcd"));

    assertThat(AppiumDriverRunner.getAndroidDriver().isKeyboardShown())
      .isTrue();
    $(AppiumBy.accessibilityId("Username input field")).shouldHave(text("abcd"));
  }
}
