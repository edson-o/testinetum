Feature: Operaciones CRUD en API


  @CrearApi
  Scenario: Crear Usuario
    Given el actor usa la API de Reqres
    When crea un nuevo usuario con nombre "Edson" y trabajo "QA Automation"
    Then validar codigo de respuesta "201"

  @ObtenerApi
  Scenario: Obtener Usuario
    Given el actor usa la API de Reqres
    When obtiene el usuario con id "2"
    Then validar codigo de respuesta "200"

  @ActualizarApi
  Scenario: Actualizar Usuario
    Given el actor usa la API de Reqres
    When actualiza el usuario con id "2" a nombre "Edson QA" y trabajo "Lead"
    Then validar codigo de respuesta "200"

  @EliminarApi
  Scenario: Eliminar Usuario
    Given el actor usa la API de Reqres
    When elimina el usuario con id "2"
    Then validar codigo de respuesta "204"
