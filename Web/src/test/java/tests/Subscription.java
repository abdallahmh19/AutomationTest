package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubscriptionValidationTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {

        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://subscribe.stctv.com/sa-en");
    }

    @Test
    public void validateSubscriptionPackagesForSaudiArabia() {
        validateSubscriptionPackages("sa");
    }

    @Test
    public void validateSubscriptionPackagesForKuwait() {
        validateSubscriptionPackages("kw");
    }

    @Test
    public void validateSubscriptionPackagesForBahrain() {
        validateSubscriptionPackages("bh");
    }

    private void validateSubscriptionPackages(String country) {
        
        // Find and click on the country 
        WebElement countryBtn = driver.findElement(By.className("country-current"))
        countryBtn.click();

        // Select the specified country
        WebElement countryOption = driver.findElement(By.xpath("//a[@id='" + country + "']"));
        countryOption.click();

        // Find and validate subscription packages
        // Find subscription packages elements
        List<WebElement> subscriptionPackagesList = driver.findElements(By.xpath("//div[@class='price']//b"));

        // Check if all elements are not null
        for (WebElement subscriptionPackage : subscriptionPackagesList) {
            if (subscriptionPackage.getText() != null && !subscriptionPackage.getText().isEmpty()) {
                System.out.println("Subscription Package: " + subscriptionPackage.getText());
            } else {
                System.out.println("Subscription Package is null or empty.");
            }
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
