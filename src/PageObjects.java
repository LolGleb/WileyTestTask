import org.openqa.selenium.By;

import java.util.concurrent.ThreadLocalRandom;

public class PageObjects {

    int randomNum = ThreadLocalRandom.current().nextInt(1, 21);

    public String pageURL = "http://www.wiley.com/WileyCDA/";

    //Main Navigation
    public By navHome = By.xpath("//a[text()='Home']");

    public By navSub = By.xpath("//a[text()='Subjects']");

    public By navAbout = By.xpath("//a[text()='About Wiley']");

    public By navContact = By.xpath("//a[text()='Contact Us']");

    public By navHelp = By.xpath("//a[text()='Help']");

    //Resources
    public By resStud = By.xpath("//a[text()='Students'][@href='/WileyCDA/Section/id-404702.html']");

    public By resAuth = By.xpath("//a[text()='Authors'][@href='/WileyCDA/Section/id-301837.html']");

    public By resInstruct = By.xpath("//a[text()='Instructors'][@href='/WileyCDA/Section/id-302247.html']");

    public By resLibr = By.xpath("//a[text()='Librarians'][@href='/WileyCDA/Section/id-302238.html']");

    public By resSoc = By.xpath("//a[text()='Societies'][@href='/WileyCDA/Section/id-301962.html']");

    public By resConf = By.xpath("//a[text()='Conferences'][@href='/WileyCDA/Section/id-301450.html']");

    public By resBook = By.xpath("//a[text()='Booksellers'][@href='/WileyCDA/Section/id-302242.html']");

    public By resCorp = By.xpath("//a[contains(text(), 'Corporat')][@href='/WileyCDA/Section/id-352020.html']");

    public By resInstitut = By.xpath("//a[text()='Institutions'][@href='http://wileyedsolutions.com/ ']");

    //Inputs & Buttons
    public By btnSignUp = By.id("id31");

    public By inputEmail = By.id("EmailAddress");

    public By inputSearch = By.id("query");

    public By btnSearch = By.xpath("//input[@type='submit']");

    //Search Result
    public By searchResultElements = By.xpath("//div[@class='product-listing size100']");

    public By titleSearchResultRundomElement = By.xpath("//div[@id='search-results']/div[" + randomNum + "]/div[2]/a");

    public By itemPageH1 = By.cssSelector("h1.productDetail-title");

    //Students
    public By studH1 = By.xpath("//h1[text()='Students']");

    public By activeStud = By.xpath("//li[@class='active autonavItem parent']/span[text()='Students']");
}