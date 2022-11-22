package integration.android;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@ExtendWith(TextReportExtension.class)
class AndroidScrollTest extends BaseApiDemosTest {

  @Test
  void testScrollToElement() {
    $(By.xpath(".//*[@text='Views']")).click();
    $(By.xpath(".//*[@text='Tabs']")).scrollTo().click();

    $(By.xpath(".//*[@text='1. Content By Id']"))
      .shouldHave(visible);
  }
}
