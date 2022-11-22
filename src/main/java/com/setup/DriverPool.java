package com.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class DriverPool {

    private static AndroidDriver driverInstance;

    public static AndroidDriver getDriverInstance() {

        return DriverPool.driverInstance;
    }

    public void setDriverInstance(AndroidDriver instance) {

        DriverPool.driverInstance = instance;
    }
}