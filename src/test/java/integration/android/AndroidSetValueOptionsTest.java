package integration.android;

import com.codeborne.selenide.SetValueOptions;
import com.codeborne.selenide.appium.AppiumSetValueOptions;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static io.appium.java_client.AppiumBy.xpath;

class AndroidSetValueOptionsTest extends BaseSwagLabsAndroidTest {

  @Test
  void testHideKeyboardForAndroid() {
    SelenideAppium.launchApp();

    $(xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"))
      .shouldBe(visible).click();
    $(byText("Log In")).shouldBe(visible).click();
    $(AppiumBy.accessibilityId("Username input field")).shouldBe(visible);
      //.setValue(AppiumSetValueOptions.withText("abcd123").hideKeyboard());
  }
}
