package com.juice.factory;

import com.juice.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistroPage extends Variables {

    @FindBy(how = How.XPATH, using = "//*[@aria-label='Close Welcome Banner']")
    protected WebElement closeBannerButton;
    @FindBy(how = How.ID, using = "emailControl")
    protected WebElement Email;
    @FindBy(how = How.ID, using = "passwordControl")
    protected WebElement Password;
    @FindBy(how = How.ID, using = "repeatPasswordControl")
    protected WebElement ConfirmPassword;
    @FindBy(how = How.XPATH, using = "//mat-select[@aria-label='Selection list for the security question']")
    protected WebElement securityQuestionDropdown;
    @FindBy(how = How.ID, using = "mat-option-3")
    protected WebElement opcionCumpleañosPadre;
    @FindBy(how = How.ID, using = "mat-option-2")
    protected WebElement opcionCumpleañosMadre;
    @FindBy(how = How.ID, using = "securityAnswerControl")
    protected WebElement securityAnswer;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registerButton\"]/span[1]")
    protected WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Registration completed successfully')]")
    protected WebElement registrationSuccessMessage;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Login')]")
    protected WebElement loginPageTitle;

    public RegistroPage(WebDriver driver) {
        Variables.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completarInformacion(String email, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
            closeBannerButton.click();
        } catch (Exception e) {
            System.out.println("No se encontró banner de bienvenida o ya fue cerrado");
        }

        // Completar formulario de registro
        Email.sendKeys(email);
        Password.sendKeys(pass);
        ConfirmPassword.sendKeys(pass);
    }

    public void informacionAdicional(String pregunta, String respuesta) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Hacer clic en el dropdown de preguntas de seguridad
        wait.until(ExpectedConditions.elementToBeClickable(securityQuestionDropdown));
        securityQuestionDropdown.click();

        // Seleccionar la pregunta
        if (pregunta.contains("padre")) {
            opcionCumpleañosPadre.click();
        } else if (pregunta.contains("madre")) {
            opcionCumpleañosMadre.click();
        }

        // Ingresar la respuesta de seguridad
        securityAnswer.sendKeys(respuesta);

        // Hacer clic en el botón de registro
        registerButton.click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(registrationSuccessMessage),
                    ExpectedConditions.visibilityOf(loginPageTitle)
            ));
        } catch (Exception e) {
            return false;
        }
    }
}
