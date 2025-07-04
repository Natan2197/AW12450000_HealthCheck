@acceptanceTest
Feature: Pruebas de aceptación del endpoint /api/usecase/life-status
  Validar que el servicio responde correctamente con status 200 y un mensaje esperado.
  Background:
    * url baseUrl
  Scenario: Validación exitosa del servicio /api/usecase/life-status
    Given path 'api/usecase/life-status'
    When method get
    Then status 200
    And match response ==
    """
    {
      statusCode: 200,
      messageStatus: 'Servicio ok'
    }
    """