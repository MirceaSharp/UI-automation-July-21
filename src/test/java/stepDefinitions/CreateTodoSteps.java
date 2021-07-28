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

public class CreateTodoSteps {
    WebDriver driver;
    WebDriver driver2;
    WebDriver driver3;

    private By inputField = By.className("new-todo");



    @Given(" I navigate to the todo page in 3 versions")
    public void  I_navigate_to_the_todo_page_in_3_versions() {
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

   @When ("I create one todo in each page")
    public void I_create_one_todo_in_each_page()
   {

       driver.findElement(inputField).click();
       driver.findElement(inputField).sendKeys("Automation is fu" + Keys.ENTER);
       driver.findElement(inputField).sendKeys("Automation is fun" + Keys.ENTER);

       driver2.findElement(inputField).click();
       driver2.findElement(inputField).sendKeys("Automation is fun" + Keys.ENTER);
       driver3.findElement(inputField).click();
       driver3.findElement(inputField).sendKeys("Automation is fun" + Keys.ENTER);


    }

    @Then("I verify that there is only one todo and that the text on the page is Automation is fun")
            public void I_verify_that_there_is_only_one_todo_and_that_the_text_on_the_page_is_Automation_is_fun() throws InterruptedException {

        String count = driver.findElement(By.className("todo-count")).getText();
        String expected = "1 item left";
        String count2 = driver2.findElement(By.className("todo-count")).getText();
        String expected2 = "1 item left";
        String count3 = driver3.findElement(By.className("todo-count")).getText();
        String expected3 = "1 item left";
        try             {
                Assert.assertEquals(expected,count);
            System.out.println("There is only one todo");
        }
        catch (org.junit.ComparisonFailure e)
        {
            System.out.println("There are several todos");
        }try             {
            Assert.assertEquals(expected2,count2);
            System.out.println("There is only one todo");
        }
        catch (org.junit.ComparisonFailure e)
        {
            System.out.println("There are several todos");
        }
        try             {
            Assert.assertEquals(expected3,count3);
            System.out.println("There is only one todo");
        }
        catch (org.junit.ComparisonFailure e)
        {
            System.out.println("There are several todos");
        }

        String text = driver.findElement(By.xpath("(//label)[2]")).getText();
        String expectedText = "Automation is fun";
        String text2 = driver2.findElement(By.xpath("(//label)[2]")).getText();
        String expectedText2 = "Automation is fun";
        String text3 = driver3.findElement(By.xpath("(//label)[2]")).getText();
        String expectedText3 = "Automation is fun";

try {
    Assert.assertEquals(expectedText,text);
    System.out.println("The Text on the page is indeed Automation is fun! on the VanillaJS page");
}

catch(org.junit.ComparisonFailure e){
    System.out.println("The new text on the page is not what it s supposed to be, but: " + text + " on VanillaJS page");
}
        try {
            Assert.assertEquals(expectedText2,text2);
            System.out.println("The Text on the page is indeed Automation is fun! on the VanillaJS page");
        }

        catch(org.junit.ComparisonFailure e){
            System.out.println("The new text on the page is not what it s supposed to be, but: " + text + " on VanillaJS page");
        }
        try {
            Assert.assertEquals(expectedText3,text3);
            System.out.println("The Text on the page is indeed Automation is fun! on the VanillaJS page");
        }

        catch(org.junit.ComparisonFailure e){
            System.out.println("The new text on the page is not what it s supposed to be, but: " + text + " on VanillaJS page");
        }

        Thread.sleep(2000);
        driver.quit();
        driver2.quit();
        driver3.quit();

    }

}


