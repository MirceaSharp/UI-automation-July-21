package stepDefinitions;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditTodoSteps {


    WebDriver driver;
    WebDriver driver2;
    WebDriver driver3;
    private By inputField = By.className("new-todo");





    @Given("I navigate to the todo list page")
    public void i_launch_the_google_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirce\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/");
        driver.findElement(By.xpath("//a[@href='examples/vanillajs']")).click();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirce\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver2 = new ChromeDriver();
        driver2.get("https://todomvc.com/");
        driver2.findElement(By.xpath("//a[@href='examples/angularjs']")).click();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirce\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver3 = new ChromeDriver();
        driver3.get("https://todomvc.com/");
        driver3.findElement(By.xpath("//a[@href='examples/react']")).click();

    }

    @When("I create three todos and change the text of the second one")
    public void i_create_3_todos() throws InterruptedException {


        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        WebElement secondTodo = driver.findElement(By.xpath(("(//li)[2]")));
        Actions action = new Actions(driver);
        action.doubleClick(secondTodo).perform();
        driver.findElement(By.xpath("//input[@class='edit']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@class='edit']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@class='edit']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@class='edit']")).sendKeys(Keys.BACK_SPACE  + "I used to be something else");
        driver.findElement(By.xpath("//input[@class='edit']")).sendKeys(Keys.ENTER);








        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        WebElement secondTodo3 = driver3.findElement(By.xpath(("(//section//div//section//ul//li)[2]")));
        Actions action3 = new Actions(driver3);
        action3.doubleClick(secondTodo3).perform();
        driver3.findElement(By.xpath("(//section//div//section//ul//li)[2]")).sendKeys(Keys.BACK_SPACE);


    }

    @Then("I can see the new text in the second todo")
    public void i_can_see_the_last_todo_marked_as_completed() throws InterruptedException {


        Thread.sleep(2000);
        driver.quit();
        driver2.quit();
        driver3.quit();
    }





}
