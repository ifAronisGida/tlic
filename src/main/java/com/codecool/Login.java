package com.codecool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends POM {

    @FindBy(xpath = "/html/body/app-root/app-login/div/form/div[1]/input")
    private WebElement userNameField;

    @FindBy(xpath = "/html/body/app-root/app-login/div/form/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-login/div/form/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/app-root/app-main-layout/div/div/app-navbar/nav/div/div[2]/ul/li[5]")
    private WebElement loggedInUsername;

    @FindBy(className = "alert")
    private WebElement invalidWarning;

    @FindBy(xpath = "/html/body/app-root/app-login/div/form/div[2]/div/div")
    private WebElement shortPwWarning;

    public Login(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public final String LOGIN_URL = "http://totallylegit.xyz/login";

    public void openLoginPage(){
        driver.get(LOGIN_URL);
    }

    private void fillUserName(String userName){
        if (userName != null){
            waitForClickable(userNameField);
            userNameField.sendKeys(userName);
        }
    }

    private void fillPassword(String password){
        if (password != null){
            waitForClickable(passwordField);
            passwordField.sendKeys(password);
        }
    }

    public void fullLogin(String username, String password){
        if (password != null && username != null){
            fillUserName(username);
            fillPassword(password);
            loginButton.click();
        }
    }

    public String getUsername(){
        wait(loggedInUsername);
        return loggedInUsername.getText();
    }

    public String getInvalidWarning(){
        wait(invalidWarning);
        return invalidWarning.getText();
    }

    public String getShortPwWarning() {
        return shortPwWarning.getText();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
