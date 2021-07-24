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


    private int completedTodoCount = 0;
    private int completedTodoCount2 = 0;
    private int completedTodoCount3 = 0;
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

    @Then("I can see that the last todo is in fact completed")
    public void i_can_see_that_the_last_todo_is_in_fact_completed() throws InterruptedException {

        try {
            WebElement a = driver.findElement(By.xpath("//li[@class='completed']"));
            // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
            if (a != null) { // Element was present and found.
                if (a.isDisplayed()) {
                    System.out.println("The last element is surely completed, this has been checked");
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Please recheck previous step because the last element, which you deemed as completed is in fact not completed");
        }

        try {
            WebElement a = driver2.findElement(By.xpath("//li[@class='ng-scope completed']"));
            // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
            if (a != null) { // Element was present and found.
                if (a.isDisplayed()) {
                    System.out.println("The last element is surely completed, this has been checked");
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Please recheck previous step because the last element, which you deemed as completed is in fact not completed");
        }

        try {
            WebElement a = driver3.findElement(By.xpath("//li[@class='completed']"));
            // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
            if (a != null) { // Element was present and found.
                if (a.isDisplayed()) {
                    System.out.println("The last element is surely completed, this has been checked");
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Please recheck previous step because the last element, which you deemed as completed is in fact not completed");
        }

    }
        @And("the number of completed todos is 1")
        public void the_number_of_completed_todos_is_1 () throws InterruptedException {

            try {
                WebElement a = driver.findElement(By.xpath("//li[@class='completed']"));
                // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
                if (a != null) { // Element was present and found.
                    if (a.isDisplayed()) {
                        completedTodoCount = driver.findElements(By.xpath("//li[@class='completed']")).size();
                        if (completedTodoCount == 1) {
                            System.out.println("There is exactly one completed todo on VanillaJS page!");

                        } else {
                            System.out.println("There are " + completedTodoCount + " completed Todos");
                        }
                    }
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("There are no completed todos");
            }


            if (driver2.findElement(By.className("completed")).isDisplayed() == true) {

                completedTodoCount2 = driver2.findElements(By.xpath("//li[@class='ng-scope completed']")).size();
                if (completedTodoCount2 == 1) {
                    System.out.println("There is exactly one completed todo on AngularJS page!");
                } else {
                    System.out.println("There are " + completedTodoCount2 + " completed Todos");
                }
                if (completedTodoCount2 == 0) {

                    System.out.println("There are no completed todos");
                }
            }
            if (driver3.findElement(By.className("completed")).isDisplayed() == true) {

                completedTodoCount3 = driver3.findElements(By.xpath("//li[@class='completed']")).size();
                if (completedTodoCount3 == 1) {
                    System.out.println("There is exactly one completed todo on ReactJS page!");
                } else {
                    System.out.println("There are " + completedTodoCount3 + " completed Todos");
                }
                if (completedTodoCount3 == 0) {

                    System.out.println("There are no completed todos");
                }
            }
            Thread.sleep(2000);
            driver.quit();
            driver2.quit();
            driver3.quit();
        }
    }


