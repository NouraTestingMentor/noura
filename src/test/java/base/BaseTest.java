package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected static  final String Base_URL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Base_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void quit(){
        driver.quit();
    }

}
