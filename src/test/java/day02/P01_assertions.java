package day02;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class P01_assertions {
    static WebDriver driver;
    //  https://www.bestbuy.com/ Adresine gidin
    //  farkli test method'lari olusturarak asagidaki testleri yapin
    //  ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
    //  ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
    //  ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini ve tıklanlılabilir olduğunu test edin

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");


    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        System.out.println("Test-1 tamamlandı");
    }
    @Test
    public void test02(){
        String expectedWord="Rest";
        String actualTitle= driver.getTitle().toUpperCase();
        driver.findElement(By.xpath("(//img[@alt='Canada'])[1]")).click();
        Assertions.assertFalse(actualTitle.contains(expectedWord.toUpperCase()));
        System.out.println("Test-2 tamamlandı");
    }

    @Test
    public void test03(){
        driver.findElement(By.xpath("(//img[@alt='Canada'])[1]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='styles-module_logo__XL03c']")).isDisplayed());
        System.out.println("Logo is displayed");
    }
    @Test
    public void test04(){
        driver.findElement(By.xpath("(//img[@alt='Canada'])[1]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@data-automation='x-language']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@data-automation='x-language']")).isEnabled());
        System.out.println("FrancaisLinkTest PASSED");
    }
}
