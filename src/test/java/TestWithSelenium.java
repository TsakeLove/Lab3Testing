import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class TestWithSelenium {

    private static final String email = "";
    private static final String email2 = "";
    private static final String wrongEmail = "asasq3@221.1";
    private static final String password = "";
    private static final String trueLink = "hromadske.ua";
    private static final String err = "Мы заметили несколько необычных попыток входа в вашу учетную запись. С целью обеспечения ее безопасности просим вас ввести свой номер телефона или имя пользователя, чтобы подтвердить, что это действительно вы.";
    private static final String wrongData = "Введенные адрес электронной почты и пароль не совпадают с сохраненными в нашей базе данных. Проверьте правильность введенных данных и повторите попытку.";
    private static final long timeOutInSeconds = 10;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        System.out.println("Test start");
    }

    @Test
    public void testAuthName() {



        WebDriver driver = createWebDriver();
        WebDriverWait waiter = createWebDriverWait(driver);

        driver.get("https://twitter.com");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/login\"]")));
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));
        WebElement main = driver.findElement(By.id("react-root")); //id+
        main.findElement(By.name("session[username_or_email]")).sendKeys(email);
        main.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div")).click();


        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));
        driver.findElement(By.name("session[username_or_email]")).sendKeys(email2);
        driver.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div")).click();


        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > header > div > div > div > div:nth-child(1) > div.css-1dbjc4n.r-1awozwy.r-15zivkp.r-1bymd8e.r-13qz1uu > nav > a:nth-child(7)")));
        driver.findElement(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > header > div > div > div > div:nth-child(1) > div.css-1dbjc4n.r-1awozwy.r-15zivkp.r-1bymd8e.r-13qz1uu > nav > a:nth-child(7)")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > main > div > div > div > div > div > div.css-1dbjc4n.r-aqfbo4.r-14lw9ot.r-j7yic.r-rull8r.r-qklmqi.r-gtdqiz.r-1gn8etr.r-1g40b8q > div.css-1dbjc4n.r-1loqt21.r-136ojw6 > div > div > div > div > div.css-1dbjc4n.r-16y2uox.r-1wbh5a2.r-1pi2tsx.r-1777fci > div > h2 > div > div > div > span.css-901oao.css-16my406.css-bfa6kz.r-18jsvk2.r-poiln3.r-1vr29t4.r-bcqeeo.r-3s2u2q.r-qvutc0 > span > span")));
        String name = driver.findElement(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > main > div > div > div > div > div > div.css-1dbjc4n.r-aqfbo4.r-14lw9ot.r-j7yic.r-rull8r.r-qklmqi.r-gtdqiz.r-1gn8etr.r-1g40b8q > div.css-1dbjc4n.r-1loqt21.r-136ojw6 > div > div > div > div > div.css-1dbjc4n.r-16y2uox.r-1wbh5a2.r-1pi2tsx.r-1777fci > div > h2 > div > div > div > span.css-901oao.css-16my406.css-bfa6kz.r-18jsvk2.r-poiln3.r-1vr29t4.r-bcqeeo.r-3s2u2q.r-qvutc0 > span > span")).getText();
        Assert.assertEquals(name, "Data Test");
        driver.quit();
    }

    @Test
    public void testLastTwit() {
        WebDriver driver = createWebDriver();
        WebDriverWait waiter = createWebDriverWait(driver);
        //login
        driver.get("https://twitter.com");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/login\"]")));
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));
        driver.findElement(By.name("session[username_or_email]")).sendKeys(email); // name +
        driver.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div")).click();

        //login again
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));
        driver.findElement(By.name("session[username_or_email]")).sendKeys(email2);
        driver.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div")).click();
        // go to main page
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   //*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[1]")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[1]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div/div/div/div/div[2]/div[1]/div[1]/a/div/div[1]/div[1]/span/span")));
        //new post
        String hello = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div/div/div/div/div[2]/div[1]/div[1]/a/div/div[1]/div[1]/span/span")).getText();
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")).sendKeys("Hello, " + hello);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div[3]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span")));
        String lastTwit = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span")).getText();

        Assert.assertNotEquals("Hello , " + hello,lastTwit);

        driver.quit();
    }

    @Test
    public void testLinkText() {
        WebDriver driver = createWebDriver();
        WebDriverWait waiter = createWebDriverWait(driver);

        driver.get("https://twitter.com/HromadskeUA");

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > main > div > div > div > div > div > div:nth-child(2) > div > div > div:nth-child(1) > div.css-1dbjc4n.r-1ifxtd0.r-ymttw5.r-ttdzmv > div.css-1dbjc4n.r-6gpygo.r-14gqq1x > div > div > div.css-1dbjc4n.r-1awozwy.r-18u37iz.r-dnmrzs > div > span:nth-child(1) > span")));
        String errorLink = driver.findElement(By.linkText("hromadske.ua/donate")).getText();
        Assert.assertEquals(trueLink,errorLink);
        driver.quit();
    }

    @Test
    public void testErrorText() {
        WebDriver driver = createWebDriver();
        WebDriverWait waiter = createWebDriverWait(driver);


        driver.get("https://twitter.com");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/login\"]")));
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));
        driver.findElement(By.name("session[username_or_email]")).sendKeys(email);
        driver.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div")).click(); // css -
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-13qz1uu.r-417010 > main > div > div > div:nth-child(1) > div > span")));

        String willSee =  driver.findElement(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-13qz1uu.r-417010 > main > div > div > div:nth-child(1) > div > span")).getText();
        Assert.assertEquals(willSee, err);




        driver.quit();
    }

    @Test
    public void testSignUpWithWrongEmail() {
        WebDriver driver = createWebDriver();
        WebDriverWait waiter = createWebDriverWait(driver);
        driver.get("https://twitter.com/login");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-13qz1uu.r-417010 > main > div > div > div:nth-child(3) > div > div > a:nth-child(1)")));
        WebElement main = driver.findElement(By.id("react-root")); // name -
        main.findElement(By.name("session[username_or_email]")).sendKeys(wrongEmail);
        main.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-13qz1uu.r-417010 > main > div > div > div:nth-child(3) > div > div > a:nth-child(1)")));

        String trueData =  driver.findElement(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-13qz1uu.r-417010 > main > div > div > div:nth-child(1) > div > div > div > div > div > div")).getText();
        Assert.assertEquals(trueData, wrongData);
        driver.quit();
    }



    @After
    public void close() {
        System.out.println("Test end");
    }

    private WebDriver createWebDriver() {
        return new ChromeDriver(createChromeOptions());
    }

    private WebDriverWait createWebDriverWait(WebDriver driver){
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    private ChromeOptions createChromeOptions(){
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}