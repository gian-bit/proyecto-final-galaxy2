#language:es
  @iniciarsesion
  Característica: iniciarsesion

    Antecedentes:
      Dado el usuario esta en la pagina de juice-shop "https://juice-shop.herokuapp.com/#/login"

    @sesion-valido
    Esquema del escenario: inicio de sesion - credenciales validas
      Cuando el usuario ingresa su "<correo>" y "<clave>" validos
      Entonces el usuario deberia tener acceso a su cuenta
      Ejemplos:
      | correo | clave |
      | Gian@yopmail.com | Gian123456. |
      | Josue@yopmail.com | Josue123456. |

    @sesion-invalido
    Esquema del escenario: inicio de sesion - credenciales invalidas
      Cuando el usuario ingresa su "<correo>" y "<clave>" validos
      Entonces el usuario visualiza un mensaje de error
      Ejemplos:
        | correo | clave |
        | gian@yopmail.com | test123. |
        | josue@yopmail.com | test123. |