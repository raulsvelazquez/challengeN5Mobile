package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.*;
import org.apache.commons.codec.binary.Base64;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Log4j2
public class Hooks {

	protected static AppiumDriver<MobileElement> driver = null;
	protected static WebDriverWait wait;
	private static final String timestamp = new
			SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");

	@Before
	public static void createCapabilities() {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Raul's");
		caps.setCapability(MobileCapabilityType.UDID, "R5CT41M22CF");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		caps.setCapability("appPackage", "com.google.android.gm");
		caps.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");

		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<>(url, caps);
			startRecording();
			System.out.println("Iniciando Aplicacion......");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "El escenario fallo, referirse a la imagen adjunta.");
		}

		stopRecording();
		closeBrowser();
	}

	public static void startRecording() {
		((CanRecordScreen)driver).startRecordingScreen();
	}

	public static void stopRecording() {
		String media = ((CanRecordScreen)driver).stopRecordingScreen();
		String dirPath = System.getProperty("user.dir") + "/videos";
		File videoDir = new File(dirPath);

		try (FileOutputStream stream = new FileOutputStream(videoDir + File.separator + timestamp + ".mp4")) {
			stream.write(Base64.decodeBase64(media));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeBrowser() {
		driver.closeApp();
	}

	private WebElement find(String locator) {
		wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	private List<WebElement> finds(String locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}

	public void clickElement(String locator) {
		find(locator).click();
	}

	public void write(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}
}