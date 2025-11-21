import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        String msg = driver.findElement(By.id("message")).getText();
        System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს" + ", " + msg);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
        System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("Bootcamp");
        input.clear();

        driver.navigate().to("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        int yA = columnA.getLocation().getY();
        int yB = columnB.getLocation().getY();

        System.out.println("Column A's location on Y: " + yA);
        System.out.println("Column B's location on Y: " + yB);

        if (yA == yB) {
            System.out.println("სვეტები A და B წარმატებით არიან გასწორებული");
        } else {
            System.out.println("სვეტები A და B არ არიან ერთსა და იმავე Y კოორდინატზე განლაგებული");
        }

        driver.quit();
    }
}
