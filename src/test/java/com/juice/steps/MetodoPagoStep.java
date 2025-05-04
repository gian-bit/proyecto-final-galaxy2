package com.juice.steps;

import com.juice.utils.Variables;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

public class MetodoPagoStep extends Variables {

    @Cuando("el usuario completa la informacion de su tarjeta {string} {string} {string} {string}")
    public void InformacionDeLaTarjeta(String name, String cardnumber, String expirymonth, String expiryyear) {
        metodoPagoPage.metodoDePago(name, cardnumber, expirymonth, expiryyear);
    }

    @Entonces("el usuario visualizara su tarjeta agregada")
    public void tarjetaAgregada() {
        // Verificar que la tarjeta ha sido agregada correctamente
        boolean tarjetaAgregadaExitosamente = metodoPagoPage.isCardAdded();

        // Verificar que la tarjeta fue agregada exitosamente
        Assert.assertTrue("La tarjeta no fue agregada correctamente", tarjetaAgregadaExitosamente);

        // mensaje de éxito
        if (tarjetaAgregadaExitosamente) {
            System.out.println("Tarjeta agregada exitosamente");
        }
    }
}