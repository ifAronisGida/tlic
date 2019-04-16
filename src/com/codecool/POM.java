package com.codecool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class POM {

protected WebDriver driver;
protected WebDriverWait wait;

public POM (WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
}

public WebDriver getDriver() {
    return driver;
}

public void close() {
    driver.close();
}

public void wait (WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
}





}
