#language:es
@historial
Característica:  Historial Pedidos
  Como usuario del sitio
  Quiero ver mi historial
  Para visualizar mis pedidos completados

  Antecedentes:
    Dado el usuario esta en la pagina de juice-shop "https://juice-shop.herokuapp.com/#/login"

  Esquema del escenario:  Historial Pedidos
    Cuando el usuario ingresa sus credenciales "<Email>" "<Password>"
    Y se dirige a la pestaña del historial de pedidos
    Entonces el usuario deberia visualizar todos sus pedidos completados
    Ejemplos:
      | Email | Password |
      | Gian@yopmail.com | Gian123456. |
