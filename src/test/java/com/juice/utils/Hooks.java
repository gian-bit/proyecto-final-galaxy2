package com.juice.utils;

import com.juice.factory.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks extends Variables {

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));

        homePage = new HomePage(driver);
        registroPage = new RegistroPage(driver);
        direccionPage = new DireccionPage(driver);
        cestaPage = new CestaPage(driver);
        historialPage = new HistorialPage(driver);
        metodoPagoPage = new MetodoPagoPage(driver);
    }

    @Dado("el usuario esta en la pagina de juice-shop {string}")
    public void ingresarPaginaJuiceShop(String url) {
        driver.get(url);
    }

    @Cuando("el usuario ingresa sus credenciales {string} {string}")
    public void iniciarSesionConCredenciales(String correo, String clave) {
        homePage.gotoSesion(correo, clave);
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
