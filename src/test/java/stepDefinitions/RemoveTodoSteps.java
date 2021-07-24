package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RemoveTodoSteps {


    WebDriver driver;
    WebDriver driver2;
    WebDriver driver3;
    private By inputField = By.className("new-todo");


    @Given("I navigate to the todo page in 3 implementations")
    public void i_launch_the_browser() {
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


    @When(" I create 3 todos and delete one of them")
    public void I_create_3_todos_and_delete_one_of_them() throws InterruptedException {


        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        WebElement txt = driver.findElement(By.xpath(("(//li)[1]")));
        Thread.sleep(2500);
        Actions actions = new Actions(driver);
        actions.moveToElement(txt).perform();
        driver.findElement(By.className("destroy")).click();
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        WebElement txt2 = driver2.findElement(By.xpath("//li[@class='ng-scope'][2]"));
        Actions actions2 = new Actions(driver2);
        actions2.moveToElement(txt2).perform();
        driver2.findElement(By.xpath("(//button)[2]")).click();
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc1" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc2" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("abc3" + Keys.ENTER);
        WebElement txt3 = driver3.findElement(By.xpath(("(//div)[4]")));
        Thread.sleep(2500);
        Actions actions3 = new Actions(driver3);
        actions3.moveToElement(txt3).perform();
        driver3.findElement(By.xpath("(//button)[3]")).click();


    }

    @Then("I can see that there are only 2 todos left and that my todo is not present anymore")
    public void there_are_only_2_todos_left() throws InterruptedException {
        String count = driver.findElement(By.className("todo-count")).getText();
        String expected = "2 items left";
        Boolean result = expected.equals(count);

        if (result == true) {
            System.out.println("You only have two items left, that´s for sure! (VanillaJS)");
        }



        String count2 = driver2.findElement(By.className("todo-count")).getText();
        String expected2 = "2 items left";
        Boolean result2 = expected2.equals(count2);

        if (result2 == true) {
            System.out.println("You only have two items left, that´s for sure! (AngularJS)");
        }


        String count3 = driver3.findElement(By.className("todo-count")).getText();
        String expected3 = "2 items left";
        Boolean result3 = expected3.equals(count3);

        if (result3 == true) {
            System.out.println("You only have two items left, that´s for sure! (ReactJs)");
        }



    }
}