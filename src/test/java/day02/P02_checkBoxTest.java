package day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class P02_checkBoxTest {
    static WebDriver driver;
    // https://demoqa.com/checkbox adresine gidin
    // Home menüsünü açı
    // Açılan Menüde ilk üç checkbox'ı işaretleyin
    // her üç checkbox'ında işaretli olduğunu doğrulayın

    @BeforeEach
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/checkbox");

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("(//*[@stroke='currentColor'])[48]")).click();
        driver.findElement(By.xpath("(//*[@stroke='currentColor'])[52]")).click();
        driver.findElement(By.xpath("(//*[@stroke='currentColor'])[55]")).click();
        driver.findElement(By.xpath("(//*[@stroke='currentColor'])[58]")).click();
        Thread.sleep(1500);
        WebElement pp1=driver.findElement(By.xpath("(//*[@stroke='currentColor'])[52]"));

        WebElement pp2=(driver.findElement(By.xpath("(//*[@stroke='currentColor'])[55]")));

        WebElement pp3=driver.findElement(By.xpath("(//*[@stroke='currentColor'])[58]"));

        if (pp1.isSelected() && pp2.isSelected() && pp3.isSelected()){
            System.out.println("All ceheckbox iss selected");
        };

    }
}
