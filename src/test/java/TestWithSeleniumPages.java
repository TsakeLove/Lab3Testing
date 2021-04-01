import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;



public class TestWithSeleniumPages {

    private static final String email = "bicago7317@heroulo.com";
    private static final String email2 = "DataTes58765956";
    private static final String wrongEmail = "asasq3@221.1";
    private static final String password = "Aa123456";
    private static final String trueLink = "hromadske.ua";
    private static final String err = "Мы заметили несколько необычных попыток входа в вашу учетную запись. С целью обеспечения ее безопасности просим вас ввести свой номер телефона или имя пользователя, чтобы подтвердить, что это действительно вы.";
    private static final String wrongData = "Введенные адрес электронной почты и пароль не совпадают с сохраненными в нашей базе данных. Проверьте правильность введенных данных и повторите попытку.";
    private static final long timeOutInSeconds = 20;
    private WebDriverWait waiter;
    private WebDriver driver;
    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverlinux");
        driver = createWebDriver();
        waiter = createWebDriverWait(driver);
        System.out.println("Test start");
    }

    @Test
    public void testAuthName() {

        driver.get("https://allo.ua");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-form__input\"]")));
        driver.findElement(By.xpath("//*[@id=\"search-form__input\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"search-form__input\"]")).sendKeys("Xiaomi Mi 11 8/256GB Horizon Blue");
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/div[3]/div/ul/li[4]/div/div/form/button[3]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__layout\"]/div/div[2]/h1")));

        String a = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/h1")).getText();

        Assert.assertEquals(a, "Результати пошуку для 'Xiaomi Mi 11 8/256GB Horizon Blue'");
        driver.quit();
    }

//    @Test
//    public void testLastTwit() {
//        driver.get("https://allo.ua/ua/products/mobile/xiaomi-mi-11-8-256gb-horizon-blue.html");
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__layout > div > div.page__content.page__content--inverse > div.product-view > div.p-view__header.product-view__header > h1")));
//
//        Assert.assertNotEquals("Hello", "!Hello");
//
//        driver.quit();
//    }
//
//    @Test
//    public void testLinkText() {
//        //*[@id="p-comments"]/div/div[1]/div[2]/div[4]/button[2]
//        driver.get("https://allo.ua/ua/products/mobile/xiaomi-mi-11-8-256gb-horizon-blue.html");
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-buy-button\"]")));
//        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/div[1]/div/div[2]/div/a/span")).click();
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-comments\"]/div/div[1]/div[2]/div[1]/div[1]")));
//        String a = driver.findElement(By.xpath("//*[@id=\"p-comments\"]/div/div[2]/div/div[1]/div[2]/div[2]/p")).getText();
//        Assert.assertEquals(a, "Чи є в цьому смартфоні сервіси гугл?");
//        driver.quit();
//    }
//
//    @Test
//    public void testErrorText() {
//        driver.get("https://allo.ua/ua/products/mobile/xiaomi-mi-11-8-256gb-horizon-blue.html");
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-buy-button\"]")));
//        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/div[1]/div/div[2]/div/a/span")).click();
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-comments\"]/div/div[1]/div[2]/div[1]/div[1]")));
//        String a = driver.findElement(By.xpath("//*[@id=\"p-comments\"]/div/div[1]/div[2]/div[1]/div[1]")).getText();
//
//        Assert.assertEquals(a, "4.4");
//
//        driver.quit();
//    }

//    @Test
//    public void testSignUpWithWrongEmail() {
//
//        driver.get("https://allo.ua");
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-form__input\"]")));
//        driver.findElement(By.xpath("//*[@id=\"search-form__input\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"search-form__input\"]")).sendKeys("Xiaomi Mi 11 8/256GB Horizon Blue");
//        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/div[3]/div/ul/li[4]/div/div/form/button[3]")).click();
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__layout\"]/div/div[2]/h1")));
//        String a = driver.findElement(By.xpath("//*[@id=\"filter_id-1822\"]/p/span")).getText();
//
//
//        Assert.assertEquals(a, "(1)");
//        driver.quit();
//    }


    @After
    public void close() {
        driver.quit();
        System.out.println("Test end");
    }

    private WebDriver createWebDriver() {
        return new ChromeDriver(createChromeOptions());
    }

    private WebDriverWait createWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    private ChromeOptions createChromeOptions() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("headless");
        return options;
    }
}