## Diagrama UML (Representación Textual)

A continuación, se presenta la estructura de clases y sus relaciones utilizando los patrones de diseño proporcionado por Gemini AI para que se visualice mejor sus estructura:

+----------------+          usa          +----------------+
|  OrderService  | --------------------> | ProductFactory |
+----------------+                       +----------------+
        |                                        | crea
        | usa                                    v
        |                                +----------------+
        +------------------------------> |    Product     |
        |                                +----------------+
        | notifica                              ^
        v                                       | hereda
+----------------+                +-------------+-------------+
| OrderObserver  |                |             |             |
|  <<interface>> |           Electronics    Clothing         Food
+----------------+
        ^
        | implementa
+-------+-------+-------+
|               |       |
EmailNotifier  SMS..   Log..


+----------------+
| PricingStrategy| <---- usa ---- [ OrderService ]
|  <<interface>> |
+----------------+
        ^
        | implementa
+-------+---------------+---------------+
|               |               |       |
Regular...   Member...    BlackFriday.. Bulk..


## Implementacion de Patrones

Factory Method (Creación de Productos): Se utilizó para extraer la lógica de creación de los objetos Electronics, Clothing y Food. De esta manera, OrderService no necesita estar acoplado a las clases concretas y no necesita conocer los atributos específicos de cada producto (como los meses de garantía o la fecha de expiración).

Strategy (Cálculo de Descuentos): Se implementó para guardar las diferentes fórmulas de precios (RegularPricing, MemberPricing, BlackFridayPricing y BulkPricing). Esto elimina la necesidad de usar múltiples condicionales if/else dentro del cálculo total. Cumple perfectamente con el principio Abierto/Cerrado (OCP), ya que podemos agregar nuevas promociones en el futuro creando nuevas clases sin modificar el código existente.

Observer (Sistema de Notificaciones): Se aplicó para desacoplar el estado del pedido de los medios de comunicación. OrderService actúa como el Subject y simplemente avisa que "algo cambió", mientras que los Observers (EmailNotifier, SMSNotifier, LogNotifier) reaccionan de forma independiente.

## Instrucciones de Ejecución

Abra la carpeta Ecommerce-patteners en Visual Studio Code.

Va a visualizar el archivo src/Main.java y lo abre

Ya dentro haga clic en el botón "Run" (Play) ubicado en la esquina superior derecha del editor, o sobre click derecho RUN JAVA.

Verifique la consola (Terminal) en la parte inferior para observar la salida del sistema:

  1.La creación de productos de diferentes categorías.
  2.El cálculo de subtotales y aplicación de descuentos según la estrategia inyectada.
  3.Las alertas por Email, SMS y Log generadas al cambiar el estado del pedido.