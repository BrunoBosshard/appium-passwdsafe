package com.pepgo.appiumpasswdsafe.pages;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PasswdSafeFileComponents extends BaseComponents {

    public PasswdSafeFileComponents(AndroidDriver driver) {
        super(driver);
    }

    public PasswdSafeFileComponents createAndDeletePasswdSafeFile(String strFileName, String strPassword) {
        try {
            By menuFileNew = By.id(app_package_name + ":id/menu_file_new");
            By editTextFileName = By.id(app_package_name + ":id/file_name_input");
            By editTextPassword = By.id(app_package_name + ":id/password_input");
            By editTextPasswordConfirm = By.id(app_package_name + ":id/password_confirm_input");
            By confirmOK = By.id(app_package_name + ":id/ok");
            By buttonSAVE = By.xpath("//android.widget.Button[@text='SAVE']");
            By imagebuttonCloseNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='Close navigation drawer']");
            By textNoRecords =  By.xpath("//android.widget.TextView[@text='No Records']");
            By imageViewMoreOptions = By.xpath("//android.widget.ImageView[@content-desc='More options']");
            By textviewFileOperations = By.xpath("//android.widget.TextView[@text='File Operations…']");
            By textviewDeleteFile = By.xpath("//android.widget.TextView[@text='Delete File']");
            By confirmDelete = By.id(app_package_name + ":id/confirm");
            By buttonDELETE = By.xpath("//android.widget.Button[@text='DELETE']");
            // Start activity
            driver.startActivity(new Activity(app_package_name, app_activity_name));
            // Create new file
            driver.findElement(menuFileNew).click();
            // Enter file name
            waitForClickabilityOf(editTextFileName);
            driver.findElement(editTextFileName).click();
            enterText(strFileName);
            // Enter password
            driver.findElement(editTextPassword).click();
            enterText(strPassword);
            // Enter password confirmation
            driver.findElement(editTextPasswordConfirm).click();
            enterText(strPassword);
            // Click OK
            driver.findElement(confirmOK).click();
            // Click SAVE
            waitForClickabilityOf(buttonSAVE);
            driver.findElement(buttonSAVE).click();
            Thread.sleep(5000);
            // Click away the drawer, if it is displayed
            if (driver.findElements(imagebuttonCloseNavigationDrawer).size() > 0) {
                driver.findElement(imagebuttonCloseNavigationDrawer).click();
                Thread.sleep(2000);
            }
            // Assert that the file has been created and opened
            Assert.assertTrue(driver.findElements(textNoRecords).size() > 0);
            // Click for more options
            waitForVisibilityOf(imageViewMoreOptions);
            driver.findElement(imageViewMoreOptions).click();
            Thread.sleep(5000);
            // Click "File Operations…"
            driver.findElement(textviewFileOperations).click();
            // Click "Delete File"
            driver.findElement(textviewDeleteFile).click();
            // Click checkbox "Confirm"
            driver.findElement(confirmDelete).click();
            // Click "DELETE"
            waitForClickabilityOf(buttonDELETE);
            driver.findElement(buttonDELETE).click();
            driver.terminateApp(app_package_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PasswdSafeFileComponents(driver);
    }
}
