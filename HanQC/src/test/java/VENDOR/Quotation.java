package VENDOR;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class Quotation {
    private static WebDriver driver;

    @BeforeClass
    public static void Before() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test-merchant.hasaki.vn/login");
        driver.findElement(By.xpath("//input[@placeholder='Tên người dùng hoặc email']")).sendKeys("truonghan1506");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("150699");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
    }
    @Test
    public static void PO01 () throws InterruptedException {
        OrderPO();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Done Image: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    @AfterClass
    static void After() {

        driver.quit();
    }

    public static void OrderPO () throws InterruptedException {
        driver.findElement(By.xpath("//span[normalize-space()='Quotation']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Create Quotation Store']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@role='combobox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("")).click();





















    }
}

