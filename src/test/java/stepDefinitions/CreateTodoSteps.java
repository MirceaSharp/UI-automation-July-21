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

    private By inputField = By.className("new-todo");



    @Given("I launch the chrome browser")
    public void i_launch_the_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirce\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/");
        driver.findElement(By.xpath("//a[@href='examples/vanillajs']")).click();


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
        driver.findElement(inputField).sendKeys("Automation is fun" + Keys.ENTER);




    }

    @Then("I close google chrome")
    public void i_close_google_chrome() throws InterruptedException {


    }





}


