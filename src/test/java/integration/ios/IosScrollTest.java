package integration.ios;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ExtendWith(TextReportExtension.class)
class IosScrollTest extends BaseIOSTest {

  @Test
  void testScrollToElementOnIos() {
    $(By.xpath("//*[@name='Test Gesture']"))
      .shouldBe(visible)
      .click();
    $(By.xpath("//*[contains(@name,'Ocean')]"))
      .scrollTo()
      .shouldHave(visible);
  }
}
