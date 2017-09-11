import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWiley extends Helper {

    @BeforeMethod
    public void setUp() {

        driver = getDriver();

        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(50000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    @Test(description = "following steps in a test task", priority = 1)
    public void mainTest() throws InterruptedException, IOException {

        PageObjects page = new PageObjects();

        //Task1
        driver.get(page.pageURL);

        driver.manage().window().maximize();

        waitBy(page.navHome, 20);

        waitBy(page.navSub, 20);

        waitBy(page.navAbout, 20);

        waitBy(page.navContact, 20);

        waitBy(page.navHelp, 20);

        //Task2
        waitBy(page.resStud, 20);

        waitBy(page.resAuth, 20);

        waitBy(page.resInstruct, 20);

        waitBy(page.resLibr, 20);

        waitBy(page.resSoc, 20);

        waitBy(page.resConf, 20);

        waitBy(page.resBook, 20);

        waitBy(page.resCorp, 20);

        waitBy(page.resInstitut, 20);

        //Task3
        click(page.resStud);
        waitBy(page.studH1, 20);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/id-404702.html");

        //Task4
        waitBy(page.resAuth, 20);

        waitBy(page.resInstruct, 20);

        waitBy(page.resLibr, 20);

        waitBy(page.resSoc, 20);

        waitBy(page.resBook, 20);

        waitBy(page.resCorp, 20);

        waitBy(page.activeStud, 20);

        //Task5
        //look...I have already did this task. Class was already checked by xpath. And also it was already
        //checked that it is not a link, it's a <span>. If that's not enough here is my solution below
        click(page.activeStud);
        sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eu.wiley.com/WileyCDA/Section/id-404702.html");

        //Task6
        click(page.navHome);

        //Task7
        waitBy(page.btnSignUp, 20);
        click(page.btnSignUp);
        isAlertPresent();
        alertTextCorrect("Please enter email address");

        //Task8
        sendKeys(page.inputEmail, "geritaceygmail.com");
        click(page.btnSignUp);
        isAlertPresent();
        alertTextCorrect("Invalid email address.");

        //Task9
        sendKeys(page.inputSearch, "for dummies");
        click(page.btnSearch);
        List<WebElement> searchResult = driver.findElements(page.searchResultElements);
        Assert.assertTrue(searchResult.size()>0);

        //Task10
        String href = driver.findElement(page.titleSearchResultRundomElement).getAttribute("href");
        String searchResultName = driver.findElement(page.titleSearchResultRundomElement).getText();
        click(page.titleSearchResultRundomElement);
        waitBy(page.itemPageH1, 20);
        Assert.assertEquals(driver.findElement(page.itemPageH1).getText(), searchResultName);
        Assert.assertEquals(driver.getCurrentUrl(), href);

        //Task11
        click(page.navHome);

        //Task12
        //Didn't get it...task asks to check that http://wileyedsolutions.com/ but actually
        // https://edservices.wiley.com/ opens. Checking the second one
        click(page.resInstitut);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        waitBy(By.xpath("//body[@id='top']"), 20);
        //Assert.assertEquals(driver.getCurrentUrl(), "http://wileyedsolutions.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://edservices.wiley.com/");
    }
}
