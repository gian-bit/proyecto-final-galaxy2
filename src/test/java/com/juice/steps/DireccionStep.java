package com.juice.steps;

import com.juice.utils.Variables;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

public class DireccionStep extends Variables {

    @Y("el usuario inicia sesion con credenciales {string} y {string}")
    public void iniciarSesionConCredenciales(String correo, String clave) {
        homePage.gotoSesion(correo, clave);
    }

    @Cuando("el usuario navega a la página de direcciones")
    public void navegarAPaginaDeDirecciones() {
        direccionPage.navegarAPaginaDirecciones();
    }

    @Y("el usuario agrega una nueva dirección {string} {string} {string} {string} {string} {string} {string}")
    public void agregarNuevaDireccion(String pais, String nombre, String celular, String zipCode, String direccion, String ciudad, String estado) {
        direccionPage.agregarDireccion(pais, nombre, celular, zipCode, direccion, ciudad, estado);
    }

    @Entonces("el usuario visualiza la dirección agregada correctamente")
    public void verificarDireccionAgregada() {
        // Verificar que la dirección ha sido agregada
        boolean direccionAgregada = direccionPage.isDireccionAgregada();

        // verificar que la dirección fue agregada exitosamente
        Assert.assertTrue("La dirección no fue agregada correctamente", direccionAgregada);
    }
}
