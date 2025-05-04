package com.juice.steps;

import com.juice.utils.Variables;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;
import org.junit.Assert;

public class IniciarSesionStep extends Variables {

    @Cuando("el usuario ingresa su {string} y {string} validos")
    public void ingresoDeCredenciales(String correo, String clave) {
        homePage.gotoSesion(correo,clave);
    }

    @Entonces("el usuario deberia tener acceso a su cuenta")
    public void visualizarHomePage() {
        // Verificar que el inicio de sesión
        boolean loginExitoso = homePage.isLoginSuccessful();

        // Verificar que el login fue exitoso
        Assert.assertTrue("El inicio de sesión no fue exitoso", loginExitoso);

        // Mensaje de éxito
        if (loginExitoso) {
            System.out.println("Inicio de sesión exitoso");
        }
    }

    @Entonces("el usuario visualiza un mensaje de error")
    public void visualizarMensajeDeError() {
        // Verificar que se muestra un mensaje
        boolean mensajeErrorMostrado = homePage.isErrorMessageDisplayed();

        // Verificar que se muestra el mensaje de error
        Assert.assertTrue("No se mostró ningún mensaje de error", mensajeErrorMostrado);

        // Mensaje de error
        if (mensajeErrorMostrado) {
            String mensajeError = homePage.getErrorMessage();
            System.out.println("Mensaje de error mostrado: " + mensajeError);
        }
    }
}
