#language:es
@registro
  Característica:  Nuevos usuarios
    Como usuario del sitio
    Quiero crear mi cuenta
    Para comprar lo que necesite

  Antecedentes:
    Dado el usuario esta en la pagina de juice-shop "https://juice-shop.herokuapp.com/#/register"

    Esquema del escenario:  registro de nuevos usuarios
      Cuando el usuario completa la informacion de registro "<Email>" "<Password>"
      Y escoge una "<Pregunta>", indica la "<Respuesta>"
      Entonces el usuario deberia tener su cuenta creada
      Ejemplos:
        | Email | Password | Pregunta | Respuesta |
        | Gian@yopmail.com  |  Gian123456. | Cumpleaños padre | 28/03 |
        | Josue@yopmail.com | Josue123456. | Cumpleaños madre | 05/12 |

