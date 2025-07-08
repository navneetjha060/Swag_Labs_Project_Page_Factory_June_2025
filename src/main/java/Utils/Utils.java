package Utils;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class Utils extends BaseClass {

	WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    // 🔁 Switch to frame by index
    public void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    // 🔁 Switch to frame by name or ID
    public void switchToFrameByName(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    // 🔁 Switch to frame by WebElement
    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // ⬅️ Switch back to default content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // 🚨 Accept alert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // ❌ Dismiss alert
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // 📝 Get alert text
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // ✅ Send text to prompt alert
    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
}
