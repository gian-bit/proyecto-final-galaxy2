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

    public class DireccionPage extends Variables {
        @FindBy(how = How.XPATH, using = "//*[@aria-label='Close Welcome Banner']")
        protected WebElement closeBannerButton;
        @FindBy(how = How.ID, using = "navbarAccount")
        protected WebElement accountButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"mat-menu-panel-0\"]/div/button[2]")
        protected WebElement ordersAndPaymentMenu;
        @FindBy(how = How.XPATH, using = "//*[@id=\"mat-menu-panel-3\"]/div/button[3]")
        protected WebElement myAddressesOption;
        @FindBy(how = How.XPATH, using = "//button[@aria-label='Add a new address']")
        protected WebElement addNewAddressButton;
        @FindBy(how = How.ID, using = "mat-input-4")
        protected WebElement country;
        @FindBy(how = How.ID, using = "mat-input-5")
        protected WebElement name;
        @FindBy(how = How.ID, using = "mat-input-6")
        protected WebElement mobileNumber;
        @FindBy(how = How.ID, using = "mat-input-7")
        protected WebElement ZipCode;
        @FindBy(how = How.ID, using = "address")
        protected WebElement address;
        @FindBy(how = How.ID, using = "mat-input-9")
        protected WebElement city;
        @FindBy(how = How.ID, using = "mat-input-10")
        protected WebElement state;
        @FindBy(how = How.ID, using = "submitButton")
        protected WebElement submitButton;

        private String nombreGuardado;

        public DireccionPage(WebDriver driver) {
            Variables.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void navegarAPaginaDirecciones() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            try {
                wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
                closeBannerButton.click();
            } catch (Exception e) {
                System.out.println("No se encontró banner de bienvenida o ya fue cerrado");
            }

            accountButton.click();
            ordersAndPaymentMenu.click();
            myAddressesOption.click();
        }

        public void agregarDireccion(String pais, String nombre, String celular, String zipCode, String direccion, String ciudad, String estado) {

            this.nombreGuardado = nombre;

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Clic en el botón para agregar nueva dirección
            wait.until(ExpectedConditions.elementToBeClickable(addNewAddressButton));
            addNewAddressButton.click();

            // Completar el formulario
            wait.until(ExpectedConditions.elementToBeClickable(country));
            country.sendKeys(pais);
            name.sendKeys(nombre);
            mobileNumber.sendKeys(celular);
            ZipCode.sendKeys(zipCode);
            address.sendKeys(direccion);
            city.sendKeys(ciudad);
            state.sendKeys(estado);

            // Enviar el formulario
            submitButton.click();
        }

        public boolean isDireccionAgregada() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(), '" + nombreGuardado + "')]")));

                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
