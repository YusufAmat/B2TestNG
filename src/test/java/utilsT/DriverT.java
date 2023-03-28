/*
package utilsT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverT {
    //private static WebDriver driver;
    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(utilsT.Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
        //if (driver == null) {
        if (drivers.get() == null) {
            switch (browser) {
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    //driver = new EdgeDriver();
                    drivers.set(new EdgeDriver());
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");   //version 111 socket hatasi icin.
                    options.addArguments("--start-maximized");          // ilk acilista tüm ekran olarak acilir.
                    //options.addArguments("--headless");                 // arka planda calisir driver.
                    //driver = new ChromeDriver(options);
                    drivers.set(new ChromeDriver(options));
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    //driver = new SafariDriver();
                    drivers.set(new SafariDriver());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver();
                    drivers.set(new FirefoxDriver());
                    break;
            }
        }
        return drivers.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
*/
