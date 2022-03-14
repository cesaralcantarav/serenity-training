package com.automation.training.stepsdefinitions;

import com.automation.training.questions.ChooseYourCabinDisplayed;
import com.automation.training.questions.ConfirmationPaymentDisplayed;
import com.automation.training.questions.PassangersDataDisplayed;
import com.automation.training.tasks.ChooseCabin;
import com.automation.training.tasks.EnterPassangerData;
import com.automation.training.tasks.NavigateTo;
import com.automation.training.tasks.SearchTravel;
import com.automation.training.userinterfaces.ChooseYourCabinPage;
import com.automation.training.userinterfaces.ConfirmationPaymentPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchTravelStepsDef {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el (.*) desea acceder a la web de Peru Rail")
    public void elUsuarioDeseaAccederALaWebDePeruRail(String usuario) {
        theActorCalled(usuario).attemptsTo(
                NavigateTo.peruRailPage()
        );
    }

    @When("busca su viaje del tipo {string}, con el destino {string}, ruta de viaje {string}, tren {string}, fecha de partida {string}, fecha de retorno {string} y cantidad de pasajeros {string}")
    public void buscaSuViajeDelTipoConElDestinoRutaDeViajeTrenFechaDePartidaFechaDeRetornoYCantidadDePasajeros(String tipoViaje, String destino, String rutaViaje, String tren, String fechaPartida, String fechaRetorno, String cantidadPasajeros) {
        Serenity.setSessionVariable("numeroPasajeros").to(cantidadPasajeros);
        theActorInTheSpotlight().attemptsTo(
                SearchTravel.withData(tipoViaje, destino, rutaViaje, tren, fechaPartida, fechaRetorno, cantidadPasajeros)
        );
    }

    @Then("visualiza la página de selección de trenes")
    public void visualizaLaPáginaDeSelecciónDeTrenes() {
        theActorInTheSpotlight().should(
                seeThat("La página de selección de trenes", ChooseYourCabinDisplayed.btnSearchTicketNow(), is(true))
        );
    }

    @When("desea {string} cabinas")
    public void deseaCabinas(String numeroCabinas) {
        String numeroPasajeros = Serenity.sessionVariableCalled("numeroPasajeros");
        theActorInTheSpotlight().attemptsTo(
                ChooseCabin.withNumber(numeroCabinas,numeroPasajeros)
        );
    }

    @And("valida el resumen de compra")
    public void validaElResumenDeCompra() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ChooseYourCabinPage.BTN_PURCHASE_SUMMARY)
        );
    }

    @Then("el monto del carrito de compras coincide con el total")
    public void elMontoDelCarritoDeComprasCoincideConElTotal() {
        Serenity.setSessionVariable("montoTotal").to(ChooseYourCabinDisplayed.txtTotal(theActorInTheSpotlight()));
        String montoTotal = Serenity.sessionVariableCalled("montoTotal");
        theActorInTheSpotlight().should(
                seeThat("El monto total y del resumen (carrito) coinciden", ChooseYourCabinDisplayed.txtTotalSummary(), equalTo(montoTotal))
        );
    }

    @When("continúa con la operación")
    public void continúaConLaOperación() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ChooseYourCabinPage.BTN_CONTINUE)
        );
    }

    @Then("visualiza el formulario para ingresar los datos de los pasajeros")
    public void visualizaElFormularioParaIngresarLosDatosDeLosPasajeros() {
        theActorInTheSpotlight().should(
                seeThat("El formulario de datos de pasajeros", PassangersDataDisplayed.form(), equalTo(true))
        );
    }

    @When("ingresa sus datos: nombres {string}, apellido {string}, fecha de nacimiento {string}, nacionalidad {string}, tipo de documento {string}, número de documento {string}, sexo {string}, teléfono {string}, correo {string}")
    public void ingresaSusDatosNombresApellidoFechaDeNacimientoNacionalidadTipoDeDocumentoNúmeroDeDocumentoSexoTeléfonoCorreo(String nombres, String apellido, String fechaNacimiento, String nacionalidad, String tipoDocumento, String numeroDocumento, String sexo, String telefono, String correo) {
        theActorInTheSpotlight().attemptsTo(
                EnterPassangerData.withData(nombres, apellido,fechaNacimiento, nacionalidad, tipoDocumento, numeroDocumento, sexo, telefono, correo)
        );
    }

    @Then("se muestra la página del detalle de pago")
    public void seMuestraLaPáginaDelDetalleDePago() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ConfirmationPaymentPage.LBL_PAYMENT_METHOD, isVisible()).forNoMoreThan(5).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat("La página de confirmación de pago se visualiza correctamente", ConfirmationPaymentDisplayed.paymentMethod(), equalTo(true))
        );
    }
}
