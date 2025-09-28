package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
//    tao file report
    public ExtentReports extent;
//    tao object javascript de tuong tac voi giao dien
    public JavascriptExecutor javascriptExecutor;
    public ExtentTest extentTest;

//    beforeClass

    @BeforeClass
    public void setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/reports.html");
//        thiet lap ten report, name
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Selenium Test report");

//        tao doi tuong de import chi tiet test case vao file html
        extent = new ExtentReports();
//        import info extent test case vao html
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Browser", "Chrome");
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        doi khoi tao browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        tao object javascript
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void tearDownExtentReports() {
        if(extent != null) {
            extent.flush();
        }
    }


}
