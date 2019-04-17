package com.codecool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup extends POM {

    @FindBy(css = "body > app-root > app-register > div > form > div:nth-child(1) > input")
    private WebElement nameBox;

    @FindBy(css = "body > app-root > app-register > div > form > div:nth-child(2) > input")
    private WebElement userNameBox;

    @FindBy(css = "body > app-root > app-register > div > form > div:nth-child(3) > input")
    private WebElement emailBox;

    @FindBy(css = "body > app-root > app-register > div > form > div:nth-child(4) > input")
    private WebElement passwordBox;

    @FindBy(css = "body > app-root > app-register > div > form > div:nth-child(5) > button")
    private WebElement registerButton;

    @FindBy(xpath = "/html/body/app-root/app-register/div[contains(text(),'registration is successful.')]")
    private WebElement successText;

    private static final String SIGNUP_URL = "http://totallylegit.xyz/signup";
    public static final String SUCCESS_STRING = "Your registration is successful. Please login!";

    public Signup (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToSignupPage() {
        driver.get(SIGNUP_URL);
    }

    public void writeName (String name) {
        nameBox.sendKeys(name);
    }

    public void writeUserName(String userName) {
        userNameBox.sendKeys(userName);
    }

    public void writeEmail (String email) {
        emailBox.sendKeys(email);
    }

    public void writePassword (String password) {
        passwordBox.sendKeys(password);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public boolean validateSignup() {
        wait(successText);
        return getPageSource().contains(SUCCESS_STRING);
    }

    public void signup(String name, String userName, String email, String password) {
        goToSignupPage();
        writeName(name);
        writeUserName(userName);
        writeEmail(email);
        writePassword(password);
        clickRegister();
    }

}
