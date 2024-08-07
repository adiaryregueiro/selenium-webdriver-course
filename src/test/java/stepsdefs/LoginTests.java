package stepsdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import stepsdefs.base.BaseTests;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    private LoginPage loginPage;
    private WebDriver driver;
    private SecureAreaPage secureArea;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("Iam in the login page")
    public void iam_in_the_login_page() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        loginPage = homePage.clickFormAuthentication();
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        secureArea = loginPage.clickLoginButton();
    }

    @Then("I should be taken to the Secure Area page")
    public void i_should_be_taken_to_the_secure_area_page() {
        assertTrue(secureArea.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String error_message) {
        Assert.assertTrue(loginPage.getMessage().contains(error_message));
    }
}
