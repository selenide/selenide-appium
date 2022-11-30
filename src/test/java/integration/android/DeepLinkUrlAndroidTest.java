package integration.android;

import com.codeborne.selenide.appium.SelenideAppium;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumSelectors.withText;

class DeepLinkUrlAndroidTest extends BaseSwagLabsAndroidTest {

  @Test
  void testDeepLinkInAndroid() {
    SelenideAppium.openAndroidDeepLink("mydemoapprn://product-details/1", "com.saucelabs.mydemoapp.rn");
    $(withText("Sauce Labs Backpack")).shouldBe(visible);
  }
}
