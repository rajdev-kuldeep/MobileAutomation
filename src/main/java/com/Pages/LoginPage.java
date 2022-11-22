package com.Pages;

import com.Steps.LoginSteps;
import com.setup.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utility.Utilities;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage extends BaseClass {
    public AndroidDriver androidDriver;

    public LoginPage(AndroidDriver androidDriver) {
        System.out.println("Checking driver in login page" + androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
      //  PageFactory.initElements((androidDriver, Duration.ofSeconds(10)), this);
    }

    @FindBy(id = "com.biforst.broonline.bigbazar:id/username")
    WebElement userTextInput;

    @FindBy(id = "com.biforst.broonline.bigbazar:id/password")
    WebElement passwordTextInput;

    @FindBy(id = "com.biforst.broonline.bigbazar:id/btn_login")
    WebElement loginButton;

    public void loginMethod(String userName, String Password){
        System.out.println("Entering User Email");
        WebElement acceptAlert = androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        Utilities.tapByElement(this.androidDriver, acceptAlert);
       // WebElement userTextin = androidDriver.findElement(By.id("com.biforst.broonline.bigbazar:id/username"));
        Utilities.tapByElement(this.androidDriver, userTextInput);
        Utilities.sendKeysToElement(userTextInput,userName);
        System.out.println("Entering User Password");
        Utilities.tapByElement(this.androidDriver, passwordTextInput);
        Utilities.sendKeysToElement(passwordTextInput,Password);
        System.out.println("Enter User"+userName+" & Password"+Password);
    }

}
