package INSIDE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class CreateIT {
    private static WebDriver driver;

    @BeforeClass
    public static void Before() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://inside.hasaki.vn:sbd4Jnws7l@test.inshasaki.com/login");
        driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("hanhvt@hasaki.vn");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
    }
    @Test
    public static void IT01 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT02 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT03 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT04 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT05 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT06 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT07 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT08 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT09 () throws InterruptedException {
        OrderIT();
    }
    @Test
    public static void IT10 () throws InterruptedException {
        OrderIT();
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

    public static void OrderIT () throws InterruptedException {
        driver.findElement(By.xpath("(//a[@href='#'])[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[7]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Create IT Actions']")).click();
        driver.findElement(By.xpath("(//a[@href='https://test.inshasaki.com/inventory/intransfer/create'])[1]")).click();
        driver.findElement(By.xpath("(//span[@role='combobox'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[4]")).click();
        driver.findElement(By.xpath("(//span[@role='combobox'])[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[2]")).click();
        driver.findElement(By.xpath("(//button[@id='create_form_submit_btn'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='col-xs-6 form-group']//input[@name='sku']")).sendKeys("200800310 "); //add sku
        driver.findElement(By.xpath("//input[@name='sku_qty']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='sku_qty']")).sendKeys("10");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click(); // add sku
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='col-xs-6 form-group']//input[@name='sku']")).sendKeys("100140008"); //add sku
        driver.findElement(By.xpath("//input[@name='sku_qty']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='sku_qty']")).sendKeys("10");
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click(); // add sku
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@name='status_confirm'])[1]")).click();
//        driver.findElement(By.xpath("(//input[@placeholder='SKU, Barcode'])[1]")).sendKeys("204900073");
//        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
//        driver.findElement(By.xpath("(//input[@id='sku_export_id'])[1]")).sendKeys("10");
//        driver.findElement(By.xpath("(//button[@id='export_btn_id'])[1]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//input[@placeholder='SKU, Barcode'])[1]")).sendKeys("204900024");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
//        driver.findElement(By.xpath("(//input[@id='sku_export_id'])[1]")).sendKeys("10");
//        driver.findElement(By.xpath("(//button[@id='export_btn_id'])[1]")).click();
//        driver.findElement(By.xpath("(//button[@name='status_export'])[1]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//button[@name='status_export'])[1]")).click();
        String Han;
        Han = driver.findElement(By.xpath("(//div[@class='col-md-5'])[1]")).getText();
        Han = Han.substring(1, 15);
        System.out.println("Code: " + Han);
        Thread.sleep(1000);



    }
}
