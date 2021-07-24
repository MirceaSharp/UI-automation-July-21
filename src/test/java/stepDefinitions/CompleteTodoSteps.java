package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.ls.LSOutput;

public class CompleteTodoSteps {

    WebDriver driver;
    WebDriver driver2;
    WebDriver driver3;
    private By inputField = By.className("new-todo");



    @Given("I navigate to the todo page")
    public void i_launch_the_google_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirce\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/");
        driver.findElement(By.xpath("//a[@href='examples/vanillajs']")).click();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirce\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver2 = new ChromeDriver();
        driver2.get("https://todomvc.com/");
        driver2.findElement(By.xpath("//a[@href='examples/angularjs']")).click();

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mirce\\Downloads\\geckodriver\\geckodriver.exe");
        driver3 = new FirefoxDriver();
        driver3.get("https://todomvc.com/");
        driver3.findElement(By.xpath("//a[@href='examples/react']")).click();

    }

    @When("I create 3 todos and mark the last one as completed")
    public void i_create_3_todos() {


        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        driver.findElement(By.xpath(("(//input)[5]"))).click();
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        driver2.findElement(By.xpath(("(//input)[7]"))).click();
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        driver3.findElement(By.xpath(("(//input)[7]"))).click();

    }

    Thread.sleep(2000);
        driver.quit();
        driver2.quit();
        driver3.quit();

