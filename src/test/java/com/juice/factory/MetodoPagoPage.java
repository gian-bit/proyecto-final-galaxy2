package com.juice.factory;

import com.juice.utils.Variables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MetodoPagoPage extends Variables {

    @FindBy(how = How.XPATH, using = "//*[@aria-label='Close Welcome Banner']")
    protected WebElement closeBannerButton;
    @FindBy(how = How.XPATH, using = "//*[@id='navbarAccount']")
    protected WebElement accountButton;
    @FindBy(how = How.ID, using = "mat-expansion-panel-header-0")
    protected WebElement addNewCardButton;
    @FindBy(how = How.ID, using = "mat-input-2")
    protected WebElement Name;
    @FindBy(how = How.ID, using = "mat-input-3")
    protected WebElement CardNumber;
    @FindBy(how = How.ID, using = "mat-input-4")
    protected WebElement ExpiryMonth;
    @FindBy(how = How.ID, using = "mat-input-5")
    protected WebElement ExpiryYear;
    @FindBy(how = How.ID, using = "submitButton")
    protected WebElement submitButton;

    private String nombreGuardado;

    public MetodoPagoPage(WebDriver driver) {
        Variables.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void metodoDePago(String name, String cardnumber, String expirymonth, String expiryyear) {
        this.nombreGuardado = name;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
            closeBannerButton.click();
        } catch (Exception e) {
            System.out.println("No se encontró banner de bienvenida o ya fue cerrado");
        }

        // Hacer clic en el botón para agregar nueva tarjeta
        addNewCardButton.click();

        // Ingresar los datos de la tarjeta
        Name.sendKeys(name);
        CardNumber.sendKeys(cardnumber);
        ExpiryMonth.sendKeys(expirymonth);
        ExpiryYear.sendKeys(expiryyear);

        // Hacer clic en el botón de enviar
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            submitButton.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", submitButton);
        }
    }

    public boolean isCardAdded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), '" + nombreGuardado + "')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
