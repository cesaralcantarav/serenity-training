package com.automation.training.tasks;

import com.automation.training.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SearchTravel implements Task {
    private final String tipoViaje;
    private final String destino;
    private final String rutaViaje;
    private final String tren;
    private final String fechaPartida;
    private final String fechaRetorno;
    private final String cantidadPasajeros;

    public SearchTravel(String tipoViaje, String destino, String rutaViaje, String tren, String fechaPartida, String fechaRetorno, String cantidadPasajeros) {
        this.tipoViaje = tipoViaje;
        this.destino = destino;
        this.rutaViaje = rutaViaje;
        this.tren = tren;
        this.fechaPartida = fechaPartida;
        this.fechaRetorno = fechaRetorno;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public static Performable withData(String tipoViaje, String destino, String rutaViaje, String tren, String fechaPartida, String fechaRetorno, String cantidadPasajeros){
        return instrumented(SearchTravel.class, tipoViaje, destino, rutaViaje, tren, fechaPartida, fechaRetorno, cantidadPasajeros);
    }

    @Step("{0} busca viaje")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(tipoViaje.equalsIgnoreCase("ida")){
            actor.attemptsTo(
                   // Click.on(HomePage.RADIO_ONE_WAY)
            );
        }
        else{
            actor.attemptsTo(
                    Click.on(HomePage.RADIO_ROUND_TRIP)
            );
        }

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(destino).from(HomePage.CBO_DESTINATION),
                SelectFromOptions.byVisibleText(rutaViaje).from(HomePage.CBO_ROUTE)
        );

        if(tren == ""){
            actor.attemptsTo(
                    Enter.theValue(fechaPartida).into(HomePage.TXT_DEPARTURE_DATE),
                    Enter.theValue(fechaRetorno).into(HomePage.TXT_RETURN_DATE)
            );
        }
        else{
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText(tren).from(HomePage.CBO_TRAIN),
                    Click.on(HomePage.TXT_DEPARTURE_DATE)
            );
            if(fechaPartida.startsWith("10", 3)){
                for(int i=0; i<7; i++){
                    actor.attemptsTo(
                            WaitUntil.the(HomePage.BTN_NEXT, isClickable()).forNoMoreThan(3).seconds(),
                            Click.on(HomePage.BTN_NEXT)
                    );
                }
                actor.attemptsTo(
                        Click.on(HomePage.LBL_DAY.of(fechaPartida.substring(0,2)).called(fechaPartida.substring(0,2)))
                );
            }
        }
        if(!tren.contains("Belmond")){
            actor.attemptsTo(
                    Click.on(HomePage.TXT_PASSANGER),
                    Enter.theValue(cantidadPasajeros).into(HomePage.TXT_PASSANGER_DETAIL)
            );
        }
        actor.attemptsTo(
                Click.on(HomePage.BTN_SEARCH)
        );


    }
}
