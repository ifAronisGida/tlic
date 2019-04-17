package com.codecool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Settings extends POM {

    private static final String SETTINGS_URL = "http://totallylegit.xyz/settings";

    @FindBy(css = "body > app-root > app-main-layout > div > div > div > div > app-settings > div:nth-child(5) > button")
    private WebElement deleteButton;

    @FindBy(css = "body > app-root > app-main-layout > div > div > div > div > app-settings > div:nth-child(2)")
    private WebElement authText;


    public Settings (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToSettingsPage() {
        driver.get(SETTINGS_URL);
    }

    public void deleteUser() {
        goToSettingsPage();
        waitForClickable(deleteButton);
        deleteButton.click();
    }
}
