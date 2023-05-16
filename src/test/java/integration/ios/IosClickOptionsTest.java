package integration.ios;

import com.codeborne.selenide.appium.AppiumClickOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

class IosClickOptionsTest extends BaseIosCalculatorTest {
  @Test
  void testIosTap() {
    $(By.name("IntegerA"))
      .shouldBe(interactable, ofSeconds(10))
      .sendKeys("3");
    $(By.name("IntegerB")).sendKeys("3");
    $(By.name("ComputeSumButton")).click(AppiumClickOptions.tap());
    $(By.name("Answer")).shouldHave(text("6"));
  }
}
