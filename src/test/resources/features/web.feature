Feature: Agregar productos al carrito de compras

  @WEBcompraUnProducto
  Scenario Outline: comprar un solo producto
    Given el actor abre la pagina web
    When ingresar el usuario "<user>" y la clave "<pass>"
    And clic in the boton Login
    And selecciona el producto "<producto>"
    And clic en el boton Add to cart
    Then el carrito debe mostrar el producto "<producto>" con precio "<precio>"

    Examples:
      | user          | pass         | producto              | precio |
      | standard_user | secret_sauce | Sauce Labs Backpack   | $29.99 |
      | standard_user | secret_sauce | Sauce Labs Bike Light | $9.99  |


  @WEBVariosProductos
  Scenario Outline: Comprar varios productos
    Given el actor abre la pagina web
    When ingresar el usuario "<user>" y la clave "<pass>"
    And clic in the boton Login
    And selecciona y agrega los productos
      | producto                 | precio |
      | Sauce Labs Bolt T-Shirt  | $15.99 |
      | Sauce Labs Fleece Jacket | $49.99 |
    Then el carrito debe mostrar los productos con sus precios

    Examples:
      | user          | pass         |
      | standard_user | secret_sauce |