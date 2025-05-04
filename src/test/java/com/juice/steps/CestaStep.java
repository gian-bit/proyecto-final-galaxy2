package com.juice.steps;

import com.juice.utils.Variables;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

public class CestaStep extends Variables {

    @Y("busca los productos {string} {string} {string} y realiza el pedido")
    public void buscarProducto(String producto1, String producto2, String producto3) {
        cestaPage.buscarProducto(producto1, producto2, producto3);
        cestaPage.indicardireccionypagar();
    }

    @Y("selecciona los productos aleatoriamente para agregar a la cesta")
    public void seleccionProducto() {
        cestaPage.seleccionProducto();
        cestaPage.indicardireccionypagar();
    }

    @Entonces("el usuario deberia visualizar sus productos pedidos")
    public void visualizarProductosEnCesta() {
        // Verificar los productos
        boolean productosSolicitados = cestaPage.verificarProductosPedidos();

        // Verificar que la tarjeta fue agregada exitosamente
        Assert.assertTrue("Los pedidos no fueron solicitados correctamente", productosSolicitados);

        // mensaje de éxito
        if (productosSolicitados) {
            System.out.println("Productos solicitados exitosamente");
        }

    }
}
