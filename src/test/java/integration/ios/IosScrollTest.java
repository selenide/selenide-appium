package integration.ios;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@ExtendWith(TextReportExtension.class)
class IosScrollTest extends BaseSauceLabAppIosTest {

  @Test
  void testScrollToElementOnIos() {
    $x("//XCUIElementTypeStaticText[@name='© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.']")
      .scrollTo()
      .shouldHave(visible);
  }
}
