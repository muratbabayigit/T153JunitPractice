package day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class P99_extraBraveDriver {
    static WebDriver driver;
    static WebElement searchBox;
    static String filmName="";
    static WebElement toolsButton;
        /*
        BeforeAll ile driver'i oluşturun ve class icinde static yapin
        Maximize edin ve 10 sn bekletin
        her biri için https://www.gooqle.com adresine gidin ilgili aramayı yapıp cikan sonuc sayisini yazdirin
        1-arama kutusuna "12 Angry Men” yazip aratın
        2-arama kutusuna "Vizontele” yazip aratın
        3-arama kutusuna "Saving Private Ryan” yazip aratın
        AfterAll ile kapatin.
     */

    @BeforeAll
    public static void setUp(){
        // Selenium chromium tabanlı tarayıcıları desteklediği için
        // Chromium tabanlı diğer tarayıcılarla da test yapılabilir
        // ChromOptions kütüphanesinden bir obje oluşturup o objeyle istediğimiz tarayıcının path'ini kullanarak
        // set etmetmiz gerekir
        ChromeOptions options= new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teraDown(){
       driver.quit();
    }
    @BeforeEach
    public void beforeTest(){
        driver.get("https://www.google.com");
        searchBox= driver.findElement(By.xpath("//*[@name='q']"));
    }

    @AfterEach
    public void afterTest(){
        toolsButton=driver.findElement(By.id("hdtb-tls"));
        toolsButton.click();
        String sonuc=driver.findElement(By.id("result-stats")).getText();
        System.out.println(filmName+" araması için "+sonuc+"\n--------------------------------------------------------------");

    }

    @Test
    public void test01(){
        filmName="12 AngryMen";
        searchBox.sendKeys(filmName+ Keys.ENTER);
    }

}
