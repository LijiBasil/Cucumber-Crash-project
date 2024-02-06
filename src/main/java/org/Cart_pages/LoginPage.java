package org.Cart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    //By Locators

    private By emailInputLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@value = 'Login']");
    private By forgotPasswordLocator = By.linkText("Forgotten Password");


    //constructor

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //methods

    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordLocator);
        passwordInput.sendKeys(password);

    }

    public void clickLoginButton(){
        WebElement LoginButton = driver.findElement(loginButtonLocator);
        LoginButton.click();
    }

    public void clickForgotPasswordLink(){
        WebElement forgotPassword = driver.findElement(forgotPasswordLocator);
        forgotPassword.click();
    }

    public boolean checkForgotPasswordLink(){
        return driver.findElement(forgotPasswordLocator).isDisplayed();
    }

    public void Login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getLoginLink(){
        String LoginLink = driver.getCurrentUrl();
        return LoginLink;
    }



    public String getForgotPasswordlink(){
        String forgotPasswordUrl = driver.getCurrentUrl();
        return forgotPasswordUrl;
    }



}
