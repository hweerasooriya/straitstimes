package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.straitstimesHomePage;
import pages.straitstimesLoginPage;
import pages.straitstimesMainArticlePage;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class straitstimesStepDef {
    ConfigFileReader configFileReader;
    private WebDriver driver = null;

    @Given("^user launch the chrome browser$")
    public void user_launch_the_chrome_browser() {
        configFileReader = new ConfigFileReader();
        if (configFileReader.getBrowser().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
    }
    @When("^user load straitstimes$")
    public void user_load_straitstimes() throws Throwable {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getUrl());
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getPageLoadTime(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }
    @When("^user clicks on login link$")
    public void user_clicks_on_login_link() throws Throwable {
        driver.findElement(straitstimesHomePage.loginLink).click();
    }
    @When("^user enters valid sign in details$")
    public void user_enters_valid_sign_in_details(DataTable loginDetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        List<Map<String, String>> signin = loginDetails.asMaps(String.class, String.class);
        driver.findElement(straitstimesLoginPage.loginIdField).sendKeys(signin.get(0).get("loginID"));
        driver.findElement(straitstimesLoginPage.loginPasswordField).sendKeys(signin.get(0).get("password"));
    }
    @When("^user clicks on \"([^\"]*)\" button in login page$")
    public void user_clicks_on_button_in_login_page(String arg1) throws Throwable {
        driver.findElement(straitstimesLoginPage.loginButton).click();
    }
    @Then("^user should be able to see username \"([^\"]*)\" in home page header$")
    public void user_should_be_able_to_see_username_in_home_page_header(String username) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(straitstimesHomePage.loginUserName));
       Assert.assertEquals("Login User Name Invalid", username,driver.findElement(straitstimesHomePage.loginUserName).getText());
    }
    @When("^user enters \"([^\"]*)\" for loginID$")
    public void user_enters_for_loginID(String loginID) throws Throwable {
        driver.findElement(straitstimesLoginPage.loginIdField).sendKeys(loginID);
    }
    @When("^user enters \"([^\"]*)\" for password$")
    public void user_enters_for_password(String password) throws Throwable {
        driver.findElement(straitstimesLoginPage.loginPasswordField).sendKeys(password);
    }
    @When("^user clicks on sign in link$")
    public void user_clicks_on_sign_in_link() throws Throwable {
        driver.findElement(straitstimesLoginPage.loginButton).click();
    }

    @When("^user navigates main article page$")
    public void user_navigates_main_article_page() throws Throwable {
        Assert.assertEquals("Invalid Heading","TOP STORIES",driver.findElement(straitstimesHomePage.MainArticleHeading).getText());
    }

    @Then("^user should be able to see main article with image/video$")
    public void user_should_be_able_to_see_main_article_with_image_video() throws Throwable {
        WebElement ImageFile = driver.findElement(straitstimesHomePage.MainArticleImage);
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
            System.out.println("Image not displayed.");
        }
        else
        {
            System.out.println("Image displayed.");
        }

    }
    @When("^user click on the main article$")
    public void user_click_on_the_main_article() throws Throwable {
        driver.findElement(straitstimesHomePage.MainArticleSummary).click();
    }
    @When("^user navigate to the main article page with image/video$")
    public void user_navigate_to_the_main_article_page_with_image_video() throws Throwable {
        //verify the page Title
        Assert.assertTrue(driver.findElement(straitstimesMainArticlePage.headingTitle).isDisplayed());
        //verify the article image
        Assert.assertTrue(driver.findElement(straitstimesMainArticlePage.mainPageImage).isDisplayed());

    }


    @After
    @Then("^user close the browser$")
    public void user_close_the_browser() throws Throwable {
        driver.quit();
    }

}
