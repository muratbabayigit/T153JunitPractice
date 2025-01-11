package day01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class P07_RegisterTest {
/*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Click on 'Signup / Login' button
        4. Enter name and email address
        5. Click 'Signup' button
         . Kayıt bilgileri sayfasına ulaştığınızı dogrulayın
        6. Fill details: Title, Name, Email, Password
        7. Select checkbox 'Sign up for our newsletter!'
        8. Select checkbox 'Receive special offers from our partners!'
        9. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        10. Click 'Create Account button'
          . hesabın oluşturulduğunu doğrulayın
        11. Click 'Continue' button
        12. Click 'Delete Account' button
          .Hesabın silindiğini doğrulayın
*/
    static WebDriver driver;
    ChromeOptions options=new ChromeOptions();
    Faker faker=new Faker();
    @BeforeEach
    public void setUp(){
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

    }

    @AfterEach
    public void tearDown(){
      driver.quit();
    }

    @Test
    public  void test(){
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress()+ Keys.ENTER);
        //First Test
        String data="ENTER ACCOUNT INFORMATION";
        String data2="enter";
        String actual=driver.findElement(By.xpath("(//*[@class='title text-center'])[1]")).getText().toUpperCase();
        Assertions.assertEquals(data.toUpperCase(),actual);
        Assertions.assertTrue(actual.contains(data2.toUpperCase()));
        System.out.println("First test PASSED");

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys(faker.internet().password(5,14));
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().phoneNumber());
        //form dolduruldu contunie butonuna tıklıyoruz
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //SECOND TEST
        String actualSubmitOk=driver.findElement(By.xpath("//*[@data-qa='account-created']")).getText().toUpperCase();
        String dataSubmitOk="Account Created!";
        Assertions.assertEquals(dataSubmitOk.toUpperCase(),actualSubmitOk);
        System.out.println("Second Test PASSED");

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //Last Test
        String actualDeleteMessage=driver.findElement(By.xpath("//*[@data-qa='account-deleted']")).getText().toLowerCase();
        String expectedDeleteWord="deleted!";
        Assertions.assertTrue(actualDeleteMessage.contains(expectedDeleteWord.toLowerCase()));
        System.out.println("Last Test Completed. All Tests Passed");

    }
}
