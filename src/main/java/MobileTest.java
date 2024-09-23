import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;



public class MobileTest {

    public static void main(String[] args) {
        try {
            BaseOptions options = new BaseOptions();
            options.setCapability("platformName", "android");
            options.setCapability("appium:automationName", "uiautomator2");
            options.setCapability("appium:platformVersion", "11");
            options.setCapability("appium:deviceName", "Automation");
            options.setCapability("appium:appPackage", "com.citmobileapp");
            options.setCapability("appium:appActivity", "com.citmobileapp.MainActivity");
            options.setCapability("appium:ensureWebviewsHavePages", true);
            options.setCapability("appium:nativeWebScreenshot", true);
            options.setCapability("appium:newCommandTimeout", 3600);
            options.setCapability("appium:connectHardwareKeyboard", true);

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement el1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(9)"));
            el1.click();

            WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Next\")"));
            el2.click();

            WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Next\")"));
            el3.click();

            WebElement el4 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
            el4.click();
            
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
