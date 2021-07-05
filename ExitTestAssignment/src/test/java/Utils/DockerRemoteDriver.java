package Utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.selenium.Test.BaseTest;

public class DockerRemoteDriver {
	public static WebDriver setUp() throws MalformedURLException {
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = null;
		if (BaseTest.prop.getProperty("dockerContainer").equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("user-agent=Chrome/91.0.4472.124");
			driver = new RemoteWebDriver(url, options);
		} else if (BaseTest.prop.getProperty("dockerContainer").equalsIgnoreCase("fireFox")) {
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(url, dc);
		} else if (BaseTest.prop.getProperty("dockerContainer").equalsIgnoreCase("edge")) {
			DesiredCapabilities dc = DesiredCapabilities.edge();
			driver = new RemoteWebDriver(url, dc);
		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("user-agent=Chrome/91.0.4472.124");
			driver = new RemoteWebDriver(url, options);
		}
		return driver;
	}

}
