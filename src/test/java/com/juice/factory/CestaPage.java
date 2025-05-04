package com.juice.factory;

import com.juice.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CestaPage extends Variables {

    @FindBy(how = How.ID, using = "searchQuery")
    protected WebElement searchButton;
    @FindBy(how = How.ID, using = "mat-input-1")
    protected WebElement searchBox;
    @FindBy(how = How.XPATH, using = "/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile/div/mat-card/div/div[2]/button")
    protected WebElement addtobasket;
    @FindBy(how = How.XPATH, using = "//mat-grid-list//mat-grid-tile")
    protected List<WebElement> productList;
    @FindBy(how = How.XPATH, using = "/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]")
    protected WebElement cartButton;
    @FindBy(how = How.ID, using = "checkoutButton")
    protected WebElement checkoutButton;
    @FindBy(how = How.ID, using = "mat-radio-47")
    protected WebElement direccion1;
    @FindBy(how = How.ID, using = "mat-radio-48")
    protected WebElement direccion2;
    @FindBy(how = How.XPATH, using = "//*[@id=\"card\"]/app-address/mat-card/div/button")
    protected WebElement continuar;
    @FindBy(how = How.ID, using = "mat-radio-49")
    protected WebElement velocidadEntrega;
    @FindBy(how = How.XPATH, using = "/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div/div[4]/button[2]")
    protected WebElement continuar2;
    @FindBy(how = How.ID, using = "mat-radio-52")
    protected WebElement card;
    @FindBy(how = How.XPATH, using = "/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[2]/button[2]")
    protected WebElement continuar3;
    @FindBy(how = How.ID, using = "checkoutButton")
    protected WebElement confirmarPedido;

    // Lista para almacenar los nombres de los productos agregados
    private List<String> addedProducts = new ArrayList<>();

    public CestaPage(WebDriver driver) {
        Variables.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buscarProducto(String producto1, String producto2, String producto3) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));

        // Seleccionar el primero producto
        searchButton.click();
        searchBox.sendKeys(producto1, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(addtobasket));
        addtobasket.click();

        // Seleccionar el segundo producto
        searchBox.clear();
        searchBox.sendKeys(producto2, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(addtobasket));
        addtobasket.click();

        // Seleccionar el tercer producto
        searchBox.clear();
        searchBox.sendKeys(producto3, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(addtobasket));
        addtobasket.click();
    }

    public void indicardireccionypagar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));

        wait.until(ExpectedConditions.visibilityOfAllElements(cartButton));
        cartButton.click();

        // Verificar productos
        wait.until(ExpectedConditions.visibilityOfAllElements(checkoutButton));
        checkoutButton.click();

        // Seleccionar direccion
        wait.until(ExpectedConditions.visibilityOfAllElements(direccion2));
        direccion2.click();
        continuar.click();

        // Seleccionar velocida de entrega
        wait.until(ExpectedConditions.visibilityOfAllElements(velocidadEntrega));
        velocidadEntrega.click();
        continuar2.click();

        // Seleccionar opcion de pago
        wait.until(ExpectedConditions.visibilityOfAllElements(card));
        card.click();
        continuar3.click();

        // Verificar y confirmar producto
        wait.until(ExpectedConditions.visibilityOfAllElements(confirmarPedido));
        confirmarPedido.click();

    }
    public void seleccionProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Esperar a que se carguen los productos
            wait.until(ExpectedConditions.visibilityOfAllElements(productList));

            // Seleccionar 3 productos aleatorios
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                if (productList.size() > 0) {
                    int randomIndex = random.nextInt(productList.size());
                    WebElement randomProduct = productList.get(randomIndex);

                    // Obtener el nombre del producto
                    String productName = randomProduct.findElement(By.xpath(".//div[contains(@class, 'item-name')]")).getText();
                    addtobasket.click();
                    addedProducts.add(productName);

                    WebElement addButton = randomProduct.findElement(By.xpath(".//button[contains(text(), 'Añadir al carrito')]"));
                    wait.until(ExpectedConditions.elementToBeClickable(addButton));
                    addButton.click();

                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar productos aleatoriamente: " + e.getMessage());
        }
    }

    public boolean verificarProductosPedidos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), '¡Gracias por su compra!')]")));
            return true;
        } catch (Exception e) {
            System.out.println("Error al realizar el pedido");
            return false;
        }
    }
}
