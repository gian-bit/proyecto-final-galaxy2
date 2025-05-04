#language:es
@cesta
Característica:  Añadir producto a la cesta
  Como usuario del sitio
  Quiero añadir mi producto a la cesta
  Para despues comprar y pagar

  Antecedentes:
    Dado el usuario esta en la pagina de juice-shop "https://juice-shop.herokuapp.com/#/login"

  Esquema del escenario:  buscar producto
    Cuando el usuario ingresa sus credenciales "<Email>" "<Password>"
    Y busca los productos "<Producto1>" "<Producto2>" "<Producto3>" y realiza el pedido
    Entonces el usuario deberia visualizar sus productos pedidos
    Ejemplos:
      | Email | Password | Producto1 | Producto2 | Producto3 |
      | Gian@yopmail.com  |  Gian123456. |  Apple Juice |  Banana Juice |  Green Smoothie |

  Esquema del escenario:  seleccionar producto
    Cuando el usuario ingresa sus credenciales "<Email>" "<Password>"
    Y selecciona los productos aleatoriamente para agregar a la cesta
    Entonces el usuario deberia visualizar sus productos pedidos
    Ejemplos:
      | Email | Password |
      | Gian@yopmail.com  |  Gian123456. |
