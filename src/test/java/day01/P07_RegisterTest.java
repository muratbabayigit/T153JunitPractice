package day01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        6. Fill details: Title, Name, Email, Password
        7. Select checkbox 'Sign up for our newsletter!'
        8. Select checkbox 'Receive special offers from our partners!'
        9. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        10. Click 'Create Account button'
        11. Click 'Continue' button
        12. Click 'Delete Account' button
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
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //System.out.println(driver.findElement(By.xpath("//a[@href='account-deleted']")).getText());

    }
}
