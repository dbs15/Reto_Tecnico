# language: es

@DatePickerFeature
Característica: Seleccionar fecha en JQuery UI Datepicker

  Como usuario, quiero seleccionar fechas en el calendario para asegurar que el componente funciona correctamente.

  @DatePickerTests
  Escenario: 1. Reserva de una cita seleccionando una fecha en el calendario
    Dado que el usuario abre la pagina de JQuery Datepicker
    Cuando el usuario selecciona el dia "15" del mes actual
    Entonces el deberia ver la fecha seleccionada en el campo de texto

  @DatePickerTests
  Escenario: 2. Selección de una fecha específica en un mes diferente
    Dado que el usuario abre la pagina de JQuery Datepicker
    Cuando el usuario navega al proximo mes y selecciona el dia "10"
    Entonces el deberia ver la fecha del proximo mes seleccionada en el campo de texto

  @DatePickerTests
  Escenario: 3. Validación de campo bloqueado
    Dado que el usuario abre la pagina de JQuery Datepicker
    Cuando el intenta ingresar la fecha "05/20/2024" manualmente
    Entonces el campo de fecha no deberia cambiar