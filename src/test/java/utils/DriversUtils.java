package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriversUtils {
    static WebDriver driver;

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        setCapabilitiesChrome();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    public static ChromeOptions setCapabilitiesChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one
        chromeOptions.setCapability("network", true); // To enable network logs
        chromeOptions.setCapability("visual", true); // To enable step by step screenshot
        chromeOptions.setCapability("video", true); // To enable video recording
        chromeOptions.setCapability("console", true); // To capture console logs
        return chromeOptions;
    }
}

