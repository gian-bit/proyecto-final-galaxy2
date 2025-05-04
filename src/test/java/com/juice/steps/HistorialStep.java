package com.juice.steps;

import com.juice.factory.HomePage;
import com.juice.utils.Variables;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

public class HistorialStep extends Variables {

    @Y("se dirige a la pestaña del historial de pedidos")
    public void dirigirseAlHistorial() {
        historialPage.visualizarHistorial();
    }

    @Entonces("el usuario deberia visualizar todos sus pedidos completados")
    public void visualizarProductosCompletados() {

        // Verificar que puda visualizar los pedidos
        boolean visualizarPedidos = historialPage.historialPedidos();

        // Usar Assert para verificar que si se haya visualizado los pedidos
            Assert.assertTrue("No se pudo visualizar los pedidos", visualizarPedidos);

        // mensaje de éxito
            if (visualizarPedidos) {
            System.out.println("Se visualizaron todos los pedidos");
        }
    }
}
