package integration.android;

import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class AndroidSetValueOptionsTest extends BaseSwagLabsAndroidTest {

  @Test
  void testHideKeyboardForAndroid() {
    SelenideAppium.openAndroidDeepLink("mydemoapprn://login", "com.saucelabs.mydemoapp.rn");
    $(AppiumBy.accessibilityId("Username input field")).shouldBe(visible);
      //.setValue(AppiumSetValueOptions.withText("abcd123").hideKeyboard());
  }
}
