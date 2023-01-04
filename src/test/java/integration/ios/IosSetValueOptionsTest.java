package integration.ios;

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

class IosSetValueOptionsTest extends BaseSwagLabsAppIosTest {

  @Test
  void testHideKeyboardForIos() throws InterruptedException {
    SelenideAppium.openIOSDeepLink("mydemoapprn://login");
    $(AppiumBy.accessibilityId("Username input field"))
      .shouldBe(visible)
      .click(AppiumClickOptions.tap())
      .setValue(AppiumSetValueOptions.withText("abcd").hideKeyboard());

    Thread.sleep(3_000);
    assertThat(AppiumDriverRunner.getIosDriver().isKeyboardShown())
      .isFalse();

    $(AppiumBy.accessibilityId("Username input field")).shouldHave(text("abcd"));
  }

  @Test
  void testSetValueOptionsForIos() throws InterruptedException {
    SelenideAppium.openIOSDeepLink("mydemoapprn://login");
    $(AppiumBy.accessibilityId("Username input field"))
      .shouldBe(visible)
      .click(AppiumClickOptions.tap())
      .setValue(AppiumSetValueOptions.withText("abcd"));

    Thread.sleep(2_000);
    assertThat(AppiumDriverRunner.getIosDriver().isKeyboardShown())
      .isTrue();
    $(AppiumBy.accessibilityId("Username input field")).shouldHave(text("abcd"));
  }
}
