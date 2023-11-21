package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriversUtils {
    static WebDriver driver;

    public static void initDriver() {
        //System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        chromeDriverInit();


        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {

        if (driver == null ) {
            initDriver();
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }

    public static void chromeDriverInit() {
        ChromeOptions chromeOptions = setCapabilitiesChromeHeadless();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    public static ChromeOptions setCapabilitiesChromeHeadless(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("-headless=new");
        System.out.println("Desired Caps: " + chromeOptions);
        return chromeOptions;
    }
}

