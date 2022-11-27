package com.codeborne.selenide.appium;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.appium.WebdriverUnwrapper.cast;
import static java.time.Duration.ofSeconds;
import static java.util.Objects.isNull;

public class SelenideAppium {

  private SelenideAppium() {
  }

  public static void launchDeepLink(String deepLinkUrl, String appPackageOrBundleId) {
    if (isNull(appPackageOrBundleId)) {
      throw new IllegalArgumentException("app package or bundle id cannot be null");
    }

    if (isAndroidDriver()) {
      launchDeepLinkInAndroid(deepLinkUrl, appPackageOrBundleId);
    } else if (isIosDriver()) {
      launchDeepLinkInIos(deepLinkUrl, appPackageOrBundleId);
    } else {
      throw new IllegalArgumentException("Please use Selenide.open() method for launching web urls");
    }
  }

  private static void launchDeepLinkInIos(String deepLinkUrl, String bundleId) {
    terminateApp(bundleId);
    openSafari();
    $x("//XCUIElementTypeTextField").shouldBe(visible, ofSeconds(30)).setValue(deepLinkUrl).pressEnter();
    $(By.xpath("//XCUIElementTypeButton[@name='Open']")).shouldBe(enabled, ofSeconds(60)).click();
  }

  private static void terminateApp(String bundleId) {
    HashMap<String, String> params = new HashMap<>();
    params.put("bundleId", bundleId);
    getRemoteWebDriver().executeScript("mobile: terminateApp", params);
  }

  private static void openSafari() {
    HashMap<String, String> params = new HashMap<>();
    params.put("bundleId", "com.apple.mobilesafari");
    getRemoteWebDriver().executeScript("mobile: launchApp", params);
  }

  private static void launchDeepLinkInAndroid(String deepLinkUrl, String appPackage) {
    HashMap<String, String> params = new HashMap<>();
    params.put("url", deepLinkUrl);
    params.put("package", appPackage);

    getRemoteWebDriver()
      .executeScript("mobile:deepLink", params);
  }

  private static RemoteWebDriver getRemoteWebDriver() {
    return (RemoteWebDriver) WebDriverRunner.getWebDriver();
  }

  public static boolean isAndroidDriver() {
    return WebDriverRunner.getWebDriver() instanceof AndroidDriver;
  }

  public static boolean isIosDriver() {
    return WebDriverRunner.getWebDriver() instanceof IOSDriver;
  }

  public static AndroidDriver getAndroidDriver() {
    return cast(WebDriverRunner.getWebDriver(), AndroidDriver.class)
      .orElseThrow(() -> new IllegalArgumentException("WebDriver cannot be casted to AndroidDriver"));
  }

  public static IOSDriver getIosDriver() {
    return cast(WebDriverRunner.getWebDriver(), IOSDriver.class)
      .orElseThrow(() -> new IllegalArgumentException("WebDriver cannot be casted to IosDriver"));
  }

  public static <T extends AppiumDriver> T getMobileDriver() {
    if (isAndroidDriver() || isIosDriver()) {
      throw new IllegalArgumentException("WebDriver is not instance of Android or Ios Driver");
    }
    return isAndroidDriver() ? (T) getAndroidDriver() : (T) getIosDriver();
  }
}
