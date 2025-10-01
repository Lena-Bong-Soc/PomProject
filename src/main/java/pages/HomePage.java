package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private Actions actions;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    //Locator
    @FindBy(tagName = "h1")
    private WebElement headerTitle;
    @FindBy(tagName = "footer")
    private  WebElement footer;
//Dung js de scroll to top, scroll to button, to element, nhung css de to dam element muon xet
    public void scrollToTop(){
        jsExecutor.executeScript("window.scrollTo(0,0);");
    }
    public void scrollToBottom(){
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
}
