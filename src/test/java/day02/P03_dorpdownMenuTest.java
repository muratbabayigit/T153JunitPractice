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
import java.util.List;

public class P03_dorpdownMenuTest {
    static WebDriver driver;
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5.Dropdown'un boyutunun 3 olduğunu test edin

    @BeforeEach
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        WebElement dropDownMenu=driver.findElement(By.id("dropdown"));

        Select select=new Select(dropDownMenu);

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText()); //Option 1

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText()); //Option 2

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText()); //Option 1

        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionList=select.getOptions();

        for (WebElement each:optionList) {
            System.out.println(each.getText());
        }


        // 5.Dropdown'un boyutunun 3 olduğunu test edin
        int actualSize=optionList.size();
        int expectedSize=3;
        Assertions.assertEquals(expectedSize,actualSize);
        System.out.println("Test Tamamalandı");
    }
}
