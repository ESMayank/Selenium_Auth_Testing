package TestSelenium.TestSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AppTest{
    public static void main(String[] args) {
       WebDriver driver = new ChromeDriver();
       driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
       By inpUsername = By.name("username");
       By inpPassword = By.name("password");
       driver.findElement(inpUsername).sendKeys("student");
       driver.findElement(inpPassword).sendKeys("Password12");
       driver.findElement(By.className("btn")).click();
       //Test Case 1 : Where the credentials are right
       if(driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/")){
          if(driver.getPageSource().contains("Congratulations") || driver.getPageSource().contains("successfully logged in")){
              System.out.println("Verify Congratulations");
          }
          if(driver.findElement(By.linkText("Log out")).isDisplayed()){
              System.out.println("Verify Log Out");
          }
       }
       else if(driver.findElement(By.className("show")).isDisplayed()){
           if(driver.findElement(By.className("show")).getText().equals("Your username is invalid!")){
               System.out.println("Username error Verified");
           }
           else if(driver.findElement(By.className("show")).getText().equals("Your password is invalid!")){
               System.out.println("Password error Verified");
           }
       }
    }
}
