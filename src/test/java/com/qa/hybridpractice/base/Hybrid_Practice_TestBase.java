package com.qa.hybridpractice.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.hybridpractice.utilities.Hybrid_Practice_Utilities;

public class Hybrid_Practice_TestBase {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public Properties prop;
	public FileInputStream ip;
	
	public Hybrid_Practice_TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\hybridpractice\\config\\config.properties");
		prop.load(ip);
		
	}

	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equalsIgnoreCase(prop.getProperty("browserName1"))) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			optionsC.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(optionsC);
		} else if (browserName.equalsIgnoreCase(prop.getProperty("browserName2"))) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver(optionsF);
		} else if (browserName.equalsIgnoreCase(prop.getProperty("browserName3"))) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			optionsE.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new EdgeDriver(optionsE);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Hybrid_Practice_Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Hybrid_Practice_Utilities.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Hybrid_Practice_Utilities.SCRIPT_TIME_OUT));
		driver.manage().deleteAllCookies();
		return driver;

	}

}
