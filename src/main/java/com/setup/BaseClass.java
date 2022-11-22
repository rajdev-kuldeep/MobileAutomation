package com.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseClass extends DesiredCapabilities {

    public AndroidDriver androidDriver;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;

    //App Capability - com.biforst.broonline.bigbazar/com.biforst.broonline.activity.LoginActivity}

    public AndroidDriver setUpRun() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("Adding Capabilities");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:deviceName", "Pixel 6");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("appium:appPackage", "com.biforst.broonline.bigbazar");
        capabilities.setCapability("appium:appActivity", "com.biforst.broonline.activity.LoginActivity");
        capabilities.setCapability("app", "C:/Users/Kuldeep_Rajdev/Downloads/Demo.apk");
        capabilities.setCapability("autoAcceptAlerts", true);
        System.out.println("Launching Server- - - Creating Session");
        service = AppiumDriverLocalService.buildService(appiumServiceBuilder(capabilities));
        service.start();
        String service_url = service.getUrl().toString();
        System.out.println("Appium Service Address: " + service_url);
        androidDriver = new AndroidDriver(new URL(service_url), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return androidDriver;
    }

    protected AppiumServiceBuilder appiumServiceBuilder(Capabilities capabilities) {
        builder = new AppiumServiceBuilder();
        //builder.withAppiumJS(new File("C:/Users/Kuldeep_Rajdev/AppData/Roaming/npm/node_modules/appium/lib/appium.js"));
        builder.withIPAddress("127.0.0.2");
        builder.usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub");
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        return builder;
    }

    protected void stopServer() {
        androidDriver.quit();
        service.stop();
    }
}