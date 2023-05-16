package integration.ios;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumSelectors.*;
import static java.time.Duration.*;

class IosSelectorsTest extends BaseIosCalculatorTest {
  @Test
  void testAppiumSelectorsInIosApp() {
    $(byTagAndName("*", "IntegerA"))
      .shouldBe(interactable, ofSeconds(10))
      .setValue("2");
    $(byName("IntegerB")).setValue("4");
    $(withName("ComputeSum")).click();
    $(withTagAndName("*", "Answ")).shouldHave(text("6"));
  }
}
