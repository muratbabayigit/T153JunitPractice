package day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class P05_LoginTest {
    /*
        1-https://babayigit.net/test/ adresine gidin
        2-Login butonuna tıklayın
        3-Username kısmına “babayigit” yazdırın
        4-Password kısmına baba123 yazdırın
        5-Login butonuna tıklayın
        6-Pasword kısmına “Mb3471&” yazdırın.
        7-Login butonuna tıklayın
        8-Sayfayı kaptın

     */

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @BeforeEach
    public void beforeTest(){
        driver.get("https://babayigit.net/test/");
        driver.findElement(By.xpath("//img[@src='img/login.png']")).click();
    }

    @AfterEach
    public void afterTest(){
        System.out.println("Giriş Denemesi Sonucu: "+driver.findElement(By.id("result")).getText());
    }

    @Test
    public void test01(){
        System.out.println("Negatif Login Testi Başlıyor");
        driver.findElement(By.id("username")).sendKeys("babayigit");
        driver.findElement(By.id("password")).sendKeys("baba123"+ Keys.TAB+Keys.ENTER);

    }
    @Test
    public void test02() throws InterruptedException {
        System.out.println("\n--------------------------------------\nPozitif Login Testi Başlıyor");
        driver.findElement(By.id("username")).sendKeys("babayigit");
        driver.findElement(By.id("password")).sendKeys("Mb3471&"+ Keys.PAGE_DOWN);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }


}
