package integration.ios;

import com.codeborne.selenide.appium.SelenideAppium;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;

class DeepLinkUrlIosTest extends BaseSauceLabAppIosTest {

  @Test
  void testDeepLinkInIos() {
    SelenideAppium.openIOSDeepLink("mydemoapprn://product-details/1");
    $(byAttribute("label", "Sauce Labs Backpack")).shouldBe(visible);

    SelenideAppium.terminateApp("com.saucelabs.mydemoapp.rn");
    SelenideAppium.openIOSDeepLink("mydemoapprn://product-details/1");
    $(byAttribute("label", "Sauce Labs Bike Light")).shouldBe(visible);
  }
}
