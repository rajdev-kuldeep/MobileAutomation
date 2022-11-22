package com.Steps;

import com.Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.setup.BaseClass;
import java.net.MalformedURLException;

public class LoginSteps extends BaseClass{
    AndroidDriver androidDriver;

    @Before
    public void setUpDriver() throws MalformedURLException {
        this.androidDriver = setUpRun();
        System.out.println("Checking driver" + this.androidDriver);
    }

   @When("^I enter valid credentials ([^\"]*) and ([^\"]*)$")
    public void iAttemptLogin(String userName, String Password){
       System.out.println("Checking driver in attempt" + this.androidDriver);
       LoginPage loginPage = new LoginPage(this.androidDriver);
       loginPage.loginMethod(userName, Password);
    }

    @Then("^I verify login is completed$")
    public void iVerifyLogin() {
        System.out.println("Login is Completed");
    }

    @After
    public void closeDriver(){
        System.out.println("Stopping Server");
        androidDriver.quit();
        stopServer();
        System.out.println("Stopped Server");
    }
}
