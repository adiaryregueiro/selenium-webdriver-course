package stepsdefs.base;
import pages.HomePage;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.EventReporter;
import utils.WindowManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.support.events.EventFiringDecorator;


public class BaseTests {

    // private EventFiringDecorator driver;
    private WebDriver driver;
    protected HomePage homePage;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        //driver = new ChromeDriver();
        driver = new EventFiringDecorator<WebDriver>(new EventReporter()).decorate(new ChromeDriver(getChromeOptions()));

        driver.get("https://the-internet.herokuapp.com/");
        goHome();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //System.out.println(driver.getTitle());

        //1 - Maximize the window
       /* driver.manage().window().maximize();

        //2 - Specific width (show Chrome iPhoneX emulator)
        Dimension size = new Dimension(375, 812);
        driver.manage().window().setSize(size);
        System.out.println(driver.getTitle());

        //3 - Fullscreen mode
        driver.manage().window().fullscreen();

        //4- findElement
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();

        //5- findElements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

         //close the window and session
        driver.quit();

        //just close the window
        //driver.close();*/
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
/*
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        //test.setUp();
        //test.ExerciseWithTagName();
        //test.ExerciseWithCSSSelector();
        test.ExerciseWithXPath();
    }*/

    public void ExerciseWithTagName() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement inputsLink = driver.findElement(By.linkText("Shifting Content"));
        inputsLink.click();

        WebElement inputsLink2 = driver.findElement(By.linkText("Example 1: Menu Element"));
        inputsLink2.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));
        System.out.println("Number of menu items: " + links.size());

        driver.quit();
    }

    public void ExerciseWithCSSSelector() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        //<a href="/shifting_content">Shifting Content</a>
        driver.findElement(By.cssSelector("a[href='/shifting_content']")).click();

        //<a href="/shifting_content/menu">Example 1: Menu Element</a>
        driver.findElement(By.cssSelector("a[href='/shifting_content/menu']")).click();
        List links = driver.findElements(By.tagName("li"));

        System.out.println("Number of menu items: " + links.size());

        driver.quit();
    }

    public void ExerciseWithXPath() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/shifting_content']"));
        driver.findElement(By.cssSelector("a[href='/shifting_content']")).click();

        driver.findElement(By.xpath("//div[@id='content']//a[@href='/shifting_content/menu']")).click();
        List links = driver.findElements(By.tagName("li"));

        System.out.println("Number of menu items: " + links.size());

        //driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    /**
     * To take screeshots for the failure tests
     *
     * @param result
     */
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screeshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
        //options.addArguments("--headless=new");
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}

