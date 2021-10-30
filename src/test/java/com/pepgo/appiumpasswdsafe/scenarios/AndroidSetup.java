package com.pepgo.appiumpasswdsafe.scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidSetup {

    protected static AndroidDriver driver;

    protected static void prepareAndroidForAppium() {
        try {
            File appDir = new File(Paths.get("").toAbsolutePath() + "/apps");
            File app = new File(appDir, "PasswdSafe.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // Use "device" as value for an (AVD) emulated device, and the phone name for a real device
            capabilities.setCapability("device","device");
            // Use the udid value from the command "adb devices"
            capabilities.setCapability("udid","emulator-5554");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("automationName","UiAutomator2");
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
            capabilities.setCapability("app", app.getAbsolutePath());
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
