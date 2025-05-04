package com.juice.steps;

import com.juice.utils.Variables;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

public class RegistroStep extends Variables {

    @Cuando("el usuario completa la informacion de registro {string} {string}")
    public void completarInformacion(String email, String pass) {
        registroPage.completarInformacion(email, pass);
    }

    @Y("escoge una {string}, indica la {string}")
    public void informacionAdicional(String pregunta, String respuesta) {
        registroPage.informacionAdicional(pregunta, respuesta);
    }

    @Entonces("el usuario deberia tener su cuenta creada")
    public void cuentaCreada() {
        // Verificar que el registro
        boolean registroExitoso = registroPage.isRegistrationSuccessful();

        // Verificar que el registro fue exitoso
        Assert.assertTrue("El registro no fue exitoso", registroExitoso);

        // mensaje de éxito
        if (registroExitoso) {
            System.out.println("Registro de usuario completado exitosamente");
        }
    }

}
