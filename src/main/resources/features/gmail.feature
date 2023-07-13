@gmail
Feature: Aplicacion Gmail

  Scenario Outline: Ingresar a la aplicacion de Gmail
    Given Ingreso a la aplicacion de Gmail
    When Ingreso el email "<email>"
    And Ingreso la clave "<clave>"
    Then Visualiza la cuenta de gmail

    Examples:
      | email                        | clave     |
      | challengetecnicon5@gmail.com | tecnicon5 |
