@test
Feature: Reservar viaje

  Scenario Outline: Reservar viaje

    Given el Usuario desea acceder a la web de Peru Rail
    When busca su viaje del tipo "<tipo_viaje>", con el destino "<destino>", ruta de viaje "<ruta_viaje>", tren "<tren>", fecha de partida "<fecha_partida>", fecha de retorno "<fecha_retorno>" y cantidad de pasajeros "<cantidad_pasajeros>"
    Then visualiza la página de selección de trenes
    When desea "<numero_cabinas>" cabinas
    And valida el resumen de compra
    Then el monto del carrito de compras coincide con el total
    When continúa con la operación
    Then visualiza el formulario para ingresar los datos de los pasajeros
    When ingresa sus datos: nombres "<nombres>", apellido "<apellido>", fecha de nacimiento "<fecha_nacimiento>", nacionalidad "<nacionalidad>", tipo de documento "<tipo_documento>", número de documento "<numero_documento>", sexo "<sexo>", teléfono "<telefono>", correo "<correo>"
    Then se muestra la página del detalle de pago

    Examples:

      | tipo_viaje | destino | ruta_viaje   | tren                             | fecha_partida | fecha_retorno | cantidad_pasajeros | numero_cabinas | nombres       | apellido  | fecha_nacimiento | nacionalidad | tipo_documento      | numero_documento | sexo | telefono     | correo                      |
      | Ida        | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 12-10-2022    | 19-10-2022    | 1                  | 1 CABIN        | Cesar Alberto | Alcántara | 07-04-1992       | Peru         | Identification Card | 47365525         | Male | +51945383809 | alcantaracesar5@hotmail.com |
