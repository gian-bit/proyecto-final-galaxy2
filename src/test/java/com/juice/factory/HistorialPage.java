package com.juice.factory;

import com.juice.utils.Variables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class HistorialPage extends Variables {

    @FindBy(how = How.ID, using = "navbarAccount")
    protected WebElement accountButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-menu-panel-0\"]/div/button[2]")
    protected WebElement ordersAndPaymentMenu;
    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-menu-panel-3\"]/div/button[1]")
    protected WebElement historialPedidosButton;

    public HistorialPage(WebDriver driver) {
        Variables.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visualizarHistorial() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));

        // Hacer clic en el botón de cuenta
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        accountButton.click();

        // Hacer clic en la opción de historial de pedidos
        ordersAndPaymentMenu.click();
        historialPedidosButton.click();

        try {
            // Esperar a que se cargue la página de historial
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), 'Order History')]")));
        } catch (Exception e) {
            System.out.println("Error al navegar al historial de pedidos: " + e.getMessage());
        }
    }

    public boolean historialPedidos() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), 'Order History')]")));

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("historial_pedidos.png"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
