import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

    protected WebDriver driver;

    protected WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");

        return new ChromeDriver();
    }

    // Timeout
    protected void sleep(int time) throws InterruptedException {

        Thread.sleep(time);

    }

    // Just a simple click
    protected void click(By by) {

        waitBy(by, 10);
        driver.findElement(by).click();

    }

    protected void sendKeys(By by, String keys) {
        driver.findElement(by).sendKeys(keys);
    }

    // Timeout till element appears
    protected void waitBy(By by, int time) {

        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(by));

    }

    //Find alert
    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    //Compare text in an alert with an example
    protected void alertTextCorrect(String text2) {
        Alert alert = driver.switchTo().alert();
        String text1 = alert.getText();
        try {
            Assert.assertTrue(text1.equals(text2));
            alert.accept();
        } catch (AssertionError ex) {
            throw new RuntimeException("Alert's text is not equal my expectations");
        }
    }
}
