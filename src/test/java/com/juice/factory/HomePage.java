package com.juice.factory;

import com.juice.utils.Variables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Variables {

    @FindBy(how = How.XPATH, using = "//*[@id='navbarAccount']")
    protected WebElement accountButton;
    @FindBy(how = How.XPATH, using = "//*[@id='navbarLoginButton']")
    protected WebElement loginButton;
    @FindBy(how = How.ID, using = "email")
    protected WebElement email;
    @FindBy(how = How.ID, using = "password")
    protected WebElement password;
    @FindBy(how = How.ID, using = "loginButton")
    protected WebElement submitLoginButton;
    @FindBy(how = How.XPATH, using = "//*[@aria-label='Close Welcome Banner']")
    protected WebElement closeBannerButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'error')]")
    protected WebElement errorMessage;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Your Basket')]")
    protected WebElement basketLink;

    /**
     * Constructor
     **/
    public HomePage(WebDriver driver) {
        Variables.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotoSesion(String correo, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
            closeBannerButton.click();
        } catch (Exception e) {
            System.out.println("No se encontró banner de bienvenida o ya fue cerrado");
        }

        // Hacer clic en el botón de cuenta
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        accountButton.click();

        // Hacer clic en el botón de inicio de sesión
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        // Ingresar credenciales
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(correo);
        password.sendKeys(pass);
        submitLoginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(basketLink));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return "No se pudo obtener el mensaje de error";
        }
    }
}
