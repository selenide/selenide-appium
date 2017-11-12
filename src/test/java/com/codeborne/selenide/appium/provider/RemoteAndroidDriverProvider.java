package com.codeborne.selenide.appium.provider;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteAndroidDriverProvider implements WebDriverProvider {
  private static final String USER_NAME = System.getProperty("user.name");
  private static final String ACCESS_KEY = System.getProperty("access.key");
  private static final String APP_ID = System.getProperty("app.id");

  @Override
  public WebDriver createDriver(DesiredCapabilities capabilities) {
    Configuration.startMaximized = false;
    Configuration.captureJavascriptErrors = false;

    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    capabilities.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, 120);
    capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    capabilities.setCapability("browserstack.debug", true);
    capabilities.setCapability("realMobile", true);
    capabilities.setCapability("device", "Google Pixel");
    capabilities.setCapability(MobileCapabilityType.APP, "bs://" + APP_ID);

    try {
      return new AndroidDriver(new URL("https://" + USER_NAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
