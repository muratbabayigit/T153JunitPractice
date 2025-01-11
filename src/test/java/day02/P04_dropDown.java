package day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P04_dropDown {
    static WebDriver driver;
    // https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
    // Ülke menüsünü locate edin
    // Türkiye Seçeneğini seçin
    // Go to website butonuna tıklayın
    // url'in com.tr içerdiğini doğrulayın


    @BeforeEach
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void test01(){
        WebElement dropDownMenu= driver.findElement(By.xpath("//*[@class='a-dropdown-container']"));
        dropDownMenu.click();
        WebElement Turkiye=driver.findElement(By.xpath("//*[@id='icp-dropdown_19']"));
        Turkiye.click();
        driver.findElement(By.id("icp-save-button")).click();
        String expWord="Çok Satanlar";
        String actWord= driver.findElement(By.xpath("//*[@data-csa-c-slot-id='nav_cs_0']")).getText();
        //Assertions.assertTrue(actWord.contains(expWord));
        System.out.println("Amazon Türkiye Sayfasıan Hoşgeldiniz");

    }
}
