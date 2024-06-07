package Dummy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class GuviSignupLoginAutomation {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the GUVI website
            driver.get("https://www.guvi.in/");

            // Locate the Signup button and click on it
            WebElement signupButton = driver.findElement(By.xpath("//a[@href='/register']"));
            signupButton.click();

            // Wait for the signup page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Fill in the signup form with required details
            driver.findElement(By.id("input-firstname")).sendKeys("Test");
            driver.findElement(By.id("input-lastname")).sendKeys("User");
            driver.findElement(By.id("input-email")).sendKeys("testuser@test.com");
            driver.findElement(By.id("input-password")).sendKeys("Test@1234");

            // Click on the "Signup" button to submit the form
            WebElement signupSubmitButton = driver.findElement(By.xpath("//button[text()='Signup']"));
            signupSubmitButton.click();

            // Wait for the page to load and verify that the user is registered successfully
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Locate the Login button and click on it
            WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
            loginButton.click();

            // Wait for the login page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Fill in the login form with the email and password used during registration
            driver.findElement(By.id("input-email")).sendKeys("testuser@test.com");
            driver.findElement(By.id("input-password")).sendKeys("Test@1234");

            // Click on the "Login" button to submit the form
            WebElement loginSubmitButton = driver.findElement(By.xpath("//button[text()='Login']"));
            loginSubmitButton.click();

            // Wait for the page to load and verify that the user is logged in successfully
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Check if the login was successful by verifying the page title or a specific element
            if (driver.getTitle().contains("GUVI Dashboard")) {
                System.out.println("User logged in successfully.");
            } else {
                System.out.println("Login failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


