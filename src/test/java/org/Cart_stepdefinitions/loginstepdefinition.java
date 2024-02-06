package org.Cart_stepdefinitions;

import com.beust.jcommander.Parameter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Cart_pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class loginstepdefinition {

    private WebDriver driver;
    private LoginPage loginPage;

@Before
    public void setUp() {

//   driver = new ChromeDriver();
//   driver = new FirefoxDriver();
   driver = new InternetExplorerDriver();
}

    @After
    public void tearDown(){
    if(driver != null){
     driver.quit();
    }
    }

    @Given("I am on the opencart webpage")
    public void i_am_on_the_opencart_webpage() {
    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
   

        loginPage = new LoginPage(driver);

    }

    @Given("I have entered valid userName and passWord")
    public void i_have_entered_valid_user_name_and_pass_word() {

      loginPage.enterEmail("lijimary25@gmail.com");
      loginPage.enterPassword("Liji@2501");
    }

    @When("I click on login button")
    public void i_click_on_login_button() {

      loginPage.clickLoginButton();
    }

    @Then("I have successfully landed the login page")
    public void i_have_successfully_landed_the_login_page() {
        Assert.assertEquals(loginPage.getLoginLink(),"https://naveenautomationlabs.com/opencart/index.php?route=account/account");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
       loginPage.enterEmail(username);
       loginPage.enterPassword(password);
    }

    @Then("I should see the indicated {string}")
    public void i_should_see_the_indicated(String error_message) {

    Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(),true);
    }

    @Given("I click on forgot password link")
    public void i_click_on_forgot_password_link() {
        loginPage.clickForgotPasswordLink();
    }

    @Then("I should navigate to the forgot password page")
    public void i_should_navigate_to_the_forgot_password_page() {
       loginPage.getForgotPasswordlink();
        Assert.assertTrue(loginPage.getForgotPasswordlink().contains("account/forgotten"));
    }


}

