#language:es
@metododepago
Característica:  realizar el pago
  Como usuario del sitio
  Quiero agregar metodo de pago
  Para poder pagar mi producto

  Antecedentes:
    Dado el usuario esta en la pagina de juice-shop "https://juice-shop.herokuapp.com/#/saved-payment-methods"

  Esquema del escenario:  Agregar metodo de pago
    Cuando el usuario completa la informacion de su tarjeta "<Name>" "<CardNumber>" "<ExpiryMonth>" "<ExpiryYear>"
    Entonces el usuario visualizara su tarjeta agregada
    Ejemplos:
      | Name | CardNumber | ExpiryMonth | ExpiryYear |
      | Gian  | 5031755734530604 | 11 | 2086 |
      | Josue | 4009175332806176 | 11 | 2086 |

