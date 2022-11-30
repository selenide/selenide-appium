package integration.android;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.withText;

class AndroidHideKeyboardTest extends BaseApiDemosTest {

  @Test
  void testHideKeyboardOnAndroid() {
    $(byAttribute("content-desc", "Views")).click();
    $(byAttribute("content-desc", "Auto Complete")).click();
    $(withText("Screen Top")).click();
    $(AppiumBy.xpath("//android.widget.AutoCompleteTextView")).click(tap())
      .setValue("test");

    Assertions.assertFalse(AppiumDriverRunner.getAndroidDriver()
                             .isKeyboardShown());
  }
}
