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



    @Given("I launch the chrome browser")
    public void i_launch_the_chrome_browser() {
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

    @When("I open todomvc homepage")
    public void i_open_the_todomvc_homepage() {


    }

    @Then("I click on the VanillaJS button")
    public void i_click_on_the_VanillaJS_button() {



    }

    @Then("I try to create a todo")
    public void i_try_to_create_a_todo() throws InterruptedException {

        WebElement txt = driver.findElement(By.className("todo-list"));
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys("Automation is fu" + Keys.ENTER);
        driver2.findElement(inputField).click();
        driver2.findElement(inputField).sendKeys("Automation is fu" + Keys.ENTER);
        driver3.findElement(inputField).click();
        driver3.findElement(inputField).sendKeys("Automation is fu" + Keys.ENTER);





    }

    @Then("I close google chrome")
    public void i_close_google_chrome() throws InterruptedException {
        String count = driver.findElement(By.className("todo-count")).getText();
        String expected = "1 item left";
        Boolean result =expected.equals(count);

        if(result==true){
            System.out.println("There is ONE Todo on the page(VanillaJS)");
        }

        String count2 = driver2.findElement(By.className("todo-count")).getText();
        String expected2 = "1 item left";
        Boolean result2 =expected2.equals(count2);

        if(result2==true){
            System.out.println("There is ONE Todo on the page(AngularJS)");
        }
        String count3 = driver3.findElement(By.className("todo-count")).getText();
        String expected3 = "1 item left";
        Boolean result3 =expected3.equals(count3);

        if(result3==true){
            System.out.println("There is ONE Todo on the page(ReactJS)");
        }

        String text = driver.findElement(By.xpath("(//label)[2]")).getText();
        String expectedText = "Automation is fun";
        Boolean resultText = expectedText.equals(text);

        if(resultText==true){
            System.out.println("The Text on the page is indeed Automation is fun! on the VanillaJS page");
        }  else {
            System.out.println("The new text on the page is not what it s supposed to be, but: " + text);
        }
        String text2 = driver.findElement(By.xpath("(//label)[2]")).getText();
        String expectedText2 = "Automation is fun";
        Boolean resultText2 = expectedText2.equals(text2);

        if(resultText2==true){
            System.out.println("The Text on the page is indeed Automation is fun! on the AngularJS page");
        }else {
            System.out.println("The new text on the page is not what it s supposed to be, but: " + text2);
        }
        String text3 = driver.findElement(By.xpath("(//label)[2]")).getText();
        String expectedText3 = "Automation is fun";
        Boolean resultText3 = expectedText3.equals(text3);

        if(resultText3==true){
            System.out.println("The Text on the page is indeed Automation is fun! on the ReactJS page");
        }else {
            System.out.println("The new text on the page is not what it s supposed to be, but: " + text3);
        }

        Thread.sleep(2000);
        driver.quit();
        driver2.quit();
        driver3.quit();

    }





}


