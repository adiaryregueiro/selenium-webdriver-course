package com.example.cursoselenium.base;
import com.example.cursoselenium.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;



    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        goHome();
        homePage = new HomePage(driver);

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
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
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

    public void ExerciseWithTagName(){
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

    public void ExerciseWithCSSSelector(){
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

    public void ExerciseWithXPath(){
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
}
