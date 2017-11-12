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

public class LocalAndroidDriverProvider implements WebDriverProvider {
  @Override
  public WebDriver createDriver(DesiredCapabilities capabilities) {
    Configuration.startMaximized = false;
    Configuration.captureJavascriptErrors = false;

    capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "0123456789ABCDEF");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");

    try {
      return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
