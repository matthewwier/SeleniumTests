import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestButtonsClicking {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws IOException {
        baseUrl = "http://localhost:5080";
        InputStream is = this.getClass().getResourceAsStream("properties");
        Properties p = new Properties();
        p.load(is);
        String browser = p.getProperty("browser");
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","./chromedriver" );
            driver = new ChromeDriver();
        }else if(browser.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver", "./geckodriver");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
        }
        else if(browser.equals("Opera")){
            System.setProperty("webdriver.opera.driver", "./operadriver");
            driver = new OperaDriver();
        }
    }

    @Test
    public void testAddTask() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign up")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("adam@email.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("adam_password");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Add task")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("form-control")).sendKeys("Task Number 1");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Tasks")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Tasks")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sign up")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(1000);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
