package integration.android;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class AndroidScrollToTest extends BaseApiDemosTest{

  @Test
  void testScrollToElement() {
    $(By.xpath(".//*[@text='Views']")).click();
    $(By.xpath(".//*[@text='Tabs']")).scrollTo().click();

    $(By.xpath(".//*[@text='1. Content By Id']"))
      .shouldHave(visible);
  }
}
