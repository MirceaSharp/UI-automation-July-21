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

    @Then("I can see that there are no todos shown")
    public void I_can_see_that_there_are_no_todos_shown(){

        String todosCountOnCompletedView = driver.findElement(By.xpath("//ul[@class='todo-list']")).getText();
        if(todosCountOnCompletedView.isEmpty()){

            System.out.println("There are no todos items to be shown on VanillaJSpage");
        }
        else{
            System.out.println(todosCountOnCompletedView);
        }
        String todosCountOnCompletedView2 = driver2.findElement(By.xpath("//ul[@class='todo-list']")).getText();
        if(todosCountOnCompletedView2.isEmpty()){

            System.out.println("There are no todos items to be shown on AngularJSpage");
        }
        else{
            System.out.println(todosCountOnCompletedView);
        }
        String todosCountOnCompletedView3 = driver3.findElement(By.xpath("//ul[@class='todo-list']")).getText();
        if(todosCountOnCompletedView3.isEmpty()){

            System.out.println("There are no todos items to be shown on ReactJSpage");
        }
        else{
            System.out.println(todosCountOnCompletedView);
        }
    }
    @And("I can see that the site shows 3 items left")
    public void I_can_see_that_the_site_shows_3_items_left(){


        String count = driver.findElement(By.className("todo-count")).getText();
        String expected = "3 items left";
        Boolean result = expected.equals(count);

        if (result == true) {
            System.out.println("You have 3 items left, that´s for sure! (VanillaJS)");
        }
        String count2 = driver2.findElement(By.className("todo-count")).getText();
        String expected2 = "3 items left";
        Boolean result2 = expected2.equals(count2);

        if (result2 == true) {
            System.out.println("You have 3 items left, that´s for sure! (AngularJS)");
        }
        String count3 = driver3.findElement(By.className("todo-count")).getText();
        String expected3 = "3 items left";
        Boolean result3 = expected3.equals(count3);

        if (result3 == true) {
            System.out.println("You have 3 items left, that´s for sure! (ReactJS)");
        }


    }
    @When ("I change the view back to All then complete 2 todos and change the view back to completed todos")
    public void I_change_the_view_back_to_All_then_complete_2_todos_and_change_the_view_back_to_completed_todos(){

        driver.findElement(By.xpath("//a[@href='#/']")).click();
        driver2.findElement(By.xpath("//a[@href='#/']")).click();
        driver3.findElement(By.xpath("//a[@href='#/']")).click();
        driver.findElement(By.xpath(("(//input)[5]"))).click();
        driver2.findElement(By.xpath(("(//input)[7]"))).click();
        driver3.findElement(By.xpath(("(//input)[7]"))).click();
        driver.findElement(By.xpath(("(//input)[4]"))).click();
        driver2.findElement(By.xpath(("(//input)[5]"))).click();
        driver3.findElement(By.xpath(("(//input)[5]"))).click();
        driver.findElement(By.xpath("//a[@href='#/completed']")).click();
        driver2.findElement(By.xpath("//a[@href='#/completed']")).click();
        driver3.findElement(By.xpath("//a[@href='#/completed']")).click();



    }
    @Then("I can see that only the completed todos are shown")
    public void I_can_see_that_only_the_completed_todos_are_shown(){

        try {
            WebElement a= driver.findElement(By.xpath("//li[@class='']"));
            // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
            if (a != null) { // Element was present and found.
                if(a.isDisplayed()) {
                    System.out.println("Unfortunately, not only completed todos are shown on the VanillaJSpage...");
                }
            }
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Only completed todos are shown on the VanillaJSpage");
        }
        try {
            WebElement a= driver2.findElement(By.xpath("//li[@class='']"));
            // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
            if (a != null) { // Element was present and found.
                if(a.isDisplayed()) {
                    System.out.println("Unfortunately, not only completed todos are shown on the AngularJSpage...");
                }
            }
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Only completed todos are shown on the AngularJSpage");
        }
        try {
            WebElement a= driver3.findElement(By.xpath("//li[@class='']"));
            // If above line throws NoSuchElementException, rest of the try block below will be skipped and you can print your desired message.
            if (a != null) { // Element was present and found.
                if(a.isDisplayed()) {
                    System.out.println("Unfortunately, not only completed todos are shown on the ReactJSpage...");
                }
            }
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Only completed todos are shown on the ReactJSpage");
        }

    }


}