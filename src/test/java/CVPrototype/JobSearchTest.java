package CVPrototype;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JobSearchTest {
    WebDriver driver = null;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Given("^I am on CV Library website and i select more search option$")
    public void i_am_on_CV_Library_website_and_i_select_more_search_option() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.cv-library.co.uk/");
        driver.manage().window().maximize();

        //accept cookies
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        WebElement accept=driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(accept);
        driver.findElement(By.xpath("//a[@id='manageSettings']/parent::div/a[2]")).click();

        // I click on more option
        driver.findElement(By.id("toggle-hp-search")).click();

    }

    @When("^I enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_enter(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("keywords")).sendKeys(arg1);
        driver.findElement(By.id("location")).sendKeys(arg2);
        driver.findElement(By.id("distance")).sendKeys(arg3);
        driver.findElement(By.id("salarymin")).sendKeys(arg4);
        driver.findElement(By.id("salarymax")).sendKeys(arg5);
        driver.findElement(By.id("salarytype")).sendKeys(arg6);
        driver.findElement(By.id("tempperm")).sendKeys(arg7);
    }

    @And("^I select Find Jobs$")
    public void i_select_Find_Jobs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //Click on find button
        driver.findElement(By.id("hp-search-btn")).click();
    }
/*
    @Then("^I can see all jobs$")
    public void i_can_see_all_jobs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //String expTitle= "Permanent Test Manager Jobs in London"
        String actTitle = driver.getTitle();
        Assert.assertTrue(actTitle.contains("Permanent Test Manager Jobs in London"));

    } */
    @Then("^I can see all jobs$")
    public void i_can_see_all_jobs() {
        String actTitle = driver.getTitle();
        Assert.assertTrue(actTitle.contains("Job Search"));

    }
    @After
    public void cleanup() throws Exception
    {
        // Test execution completed and Browser will be closed
        Thread.sleep(2000);
        driver.close();
    }

}
