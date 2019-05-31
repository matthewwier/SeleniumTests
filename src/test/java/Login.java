import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class Login {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/home/maciek/WPZ/Test/Driver/chromedriver" );
        baseUrl = "http://localhost:5080";
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("adam@email.com");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("adam_password");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        String token = webStorage.getSessionStorage().getItem("token");
        Assert.assertNotNull(token);
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
