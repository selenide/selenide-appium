package integration.android;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.appium.AppiumSelectors.withText;

import com.codeborne.selenide.appium.SelenideAppium;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeepLinkUrlAndroidTest extends BaseSwagLabsAndroidTest {
  @BeforeEach
  void setUp() {
    closeWebDriver();
  }

  @Test
  void testDeepLinkInAndroid() {
    SelenideAppium.openAndroidDeepLink("mydemoapprn://product-details/1", "com.saucelabs.mydemoapp.rn");
    $(withText("Sauce Labs Backpack")).shouldBe(visible);
  }
}
