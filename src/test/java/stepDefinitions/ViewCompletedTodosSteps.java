package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ViewCompletedTodosSteps {
    WebDriver driver;
    WebDriver driver2;
    WebDriver driver3;
    private By inputField = By.className("new-todo");

    @Given("I navigate to the todo page in all 3 implementations")
    public void I_navigate_to_the_todo_page_in_all_3_implementations() {
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

    @When("I create 3 todos and change the view to completed")
    public void I_create_3_todos_and_change_the_view_to_completed() {
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc3" + Keys.ENTER);

        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc3" + Keys.ENTER);

        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc3" + Keys.ENTER);

        driver.findElement(By.xpath("//a[@href='#/completed']")).click();
        driver2.findElement(By.xpath("//a[@href='#/completed']")).click();
        driver3.findElement(By.xpath("//a[@href='#/completed']")).click();


    }
}