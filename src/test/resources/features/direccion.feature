#language:es
@direccion
Característica: Agregar direcciones de envío
  Como usuario registrado del sitio
  Quiero agregar direcciones de envío
  Para poder completar mis pedidos posteriormente

  Antecedentes:
    Dado el usuario esta en la pagina de juice-shop "https://juice-shop.herokuapp.com/#/login"
    Y el usuario inicia sesion con credenciales "Gian@yopmail.com" y "Gian123456."

  Esquema del escenario: Agregar nueva dirección de envío
    Cuando el usuario navega a la página de direcciones
    Y el usuario agrega una nueva dirección "<Pais>" "<Nombre>" "<Celular>" "<ZipCode>" "<Direccion>" "<Ciudad>" "<Estado>"
    Entonces el usuario visualiza la dirección agregada correctamente
    Ejemplos:
      | Pais   | Nombre        | Celular     | ZipCode | Direccion             | Ciudad   | Estado   |
      | Peru   | Gian Ramirez  | 987654321   | 15001   | Av. Principal 123     | Lima     | Lima     |
      | Mexico | Josue Flores  | 123456789   | 06000   | Calle Reforma 456     | CDMX     | CDMX     |