package INSIDE;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;

public class OrderInsideS {
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
    public static void Order01() throws InterruptedException {
        Order();
    }
    @Test
    public static void Order02() throws InterruptedException {
        Order();
    }
    @Test
    public static void Order03 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order04 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order05 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order06 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order07 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order08 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order09 () throws InterruptedException {
        Order();
    }
    @Test
    public static void Order10 () throws InterruptedException {
        Order();
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
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    @AfterClass
    public static void After() {


        driver.quit();
    }
    public static void Order() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']/.. //*[text()='Sales']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@href='https://test.inshasaki.com/sales/order'])[1]")).click();
        driver.findElement(By.xpath("(//a[@type='submit'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='customer_phone_check']")).sendKeys("0344535989");
        driver.findElement(By.xpath("//*[@id='btn_check_cus_phone']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='order_address']")).sendKeys("555,DUONG 3/2,PHUONG 14,QUAN 10,HCM");
        driver.findElement(By.xpath("//*[@name='pickup_store_id']")).click();
        driver.findElement(By.xpath("//*[@id='frmOrder']/div/div/div/div[1]/div[5]/div/div/select/option[3]")).click();// 555 3/2
//        driver.findElement(By.xpath("//*[@id='frmOrder']/div/div/div/div[1]/div[5]/div/div/select/option[2]")).click();// 71 HHT
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        driver.findElement(By.xpath("//*[@name='order_shipper_id']")).click();
//        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[2]")).click();//Shoppe
//        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[3]")).click();//Pick up
//        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[4]")).click();//Lazada
//        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[5]")).click();
//        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[9]")).click();//Nhat tin
//        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[10]")).click(); // ShopeeExpress
        driver.findElement(By.xpath("//*[@id='frmOrderInfo']/div[4]/div[1]/div/select/option[7]")).click(); //GHN
        driver.findElement(By.xpath("//*[@name='order_note']")).sendKeys("HAN TEST");
        driver.findElement(By.xpath("//*[@id='btn_frmOrderInfoSM']")).click();
        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click();
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100190073");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
        driver.findElement(By.id("add_item_qty")).clear();
        driver.findElement(By.id("add_item_qty")).sendKeys("5"); // SL SKU
        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100120064");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
        driver.findElement(By.id("add_item_qty")).clear();
        driver.findElement(By.id("add_item_qty")).sendKeys("6"); // SL SKU
        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
        Thread.sleep(1000); // Thêm sku
        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100150083");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
        driver.findElement(By.id("add_item_qty")).clear();
        driver.findElement(By.id("add_item_qty")).sendKeys("5"); // SL SKU
        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
        Thread.sleep(1000); // Thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100140079");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
//        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
//        driver.findElement(By.id("add_item_qty")).clear();
//        driver.findElement(By.id("add_item_qty")).sendKeys("4"); // SL SKU
//        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
//        Thread.sleep(1000); // Thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100080050");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
//        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
//        driver.findElement(By.id("add_item_qty")).clear();
//        driver.findElement(By.id("add_item_qty")).sendKeys("5"); // SL SKU
//        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
//        Thread.sleep(1000); // Thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100080043");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
//        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
//        driver.findElement(By.id("add_item_qty")).clear();
//        driver.findElement(By.id("add_item_qty")).sendKeys("6"); // SL SKU
//        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
//        Thread.sleep(1000); // Thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100080040");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
//        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
//        driver.findElement(By.id("add_item_qty")).clear();
//        driver.findElement(By.id("add_item_qty")).sendKeys("7"); // SL SKU
//        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
//        Thread.sleep(1000); // Thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100190113");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
//        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
//        driver.findElement(By.id("add_item_qty")).clear();
//        driver.findElement(By.id("add_item_qty")).sendKeys("8"); // SL SKU
//        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
//        Thread.sleep(1000); // Thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-selection__rendered']")).click(); // thêm sku
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("100180115");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
//        driver.findElement(By.xpath("//*[@role='treeitem']")).click();
//        driver.findElement(By.id("add_item_qty")).clear();
//        driver.findElement(By.id("add_item_qty")).sendKeys("9"); // SL SKU
//        driver.findElement(By.xpath("//*[@id='btn_add_item']")).click();
//        Thread.sleep(1000); // Thêm sku
        driver.findElement(By.xpath("//*[@id='btn_frmOrderDetailSM']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@onclick='validateOrderStatus(2)']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name='btnVerify']")).click();
        String Han;
        Han = driver.findElement(By.xpath("//*[@class='content-header']/h1")).getText();
        Han = Han.substring(7, 18);
        System.out.println("Code: " + Han);
        Thread.sleep(1000);


    }
}

