package com.pepgo.appiumpasswdsafe.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponents {

    protected static AndroidDriver driver;
    String app_package_name = "com.jefftharris.passwdsafe";
    String app_activity_name = "com.jefftharris.passwdsafe.FileListActivity";

    public BaseComponents(AndroidDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void enterText(String strTextToEnter) {
        driver.pressKey(new KeyEvent(AndroidKey.DEL));
        int intCounter;
        String strKey;
        for (intCounter = 0; intCounter < strTextToEnter.length(); intCounter++) {
            strKey = strTextToEnter.substring(intCounter, intCounter + 1).toUpperCase();
            driver.pressKey(new KeyEvent(AndroidKey.valueOf(strKey)));
        }
    }
}
