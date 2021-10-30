package com.pepgo.appiumpasswdsafe.scenarios;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.pepgo.appiumpasswdsafe.pages.PasswdSafeFileComponents;

public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public static void setUp() {
        prepareAndroidForAppium();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void createAndDeletePasswdSafeFile_Test() {
        // Create and delete a new PasswdSafe file
        new PasswdSafeFileComponents(driver).createAndDeletePasswdSafeFile("myfilename", "mypassword");
    }
}
