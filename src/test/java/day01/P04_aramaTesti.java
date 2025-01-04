package day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04_aramaTesti {
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
        driver=new ChromeDriver();
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

    @Test
    public void test02(){
        filmName="Vizontele";
        searchBox.sendKeys(filmName+ Keys.ENTER);
    }

    @Test
    public void test03(){
        filmName="Saving Private Ryan";
        searchBox.sendKeys(filmName+ Keys.ENTER);
    }

}
