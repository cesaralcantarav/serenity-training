package com.automation.training.tasks;

import com.automation.training.userinterfaces.ChooseYourCabinPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseCabin implements Task {
    private final String numeroCabinas;
    private final String numeroPasajeros;

    public ChooseCabin(String numeroCabinas, String numeroPasajeros) {
        this.numeroCabinas = numeroCabinas;
        this.numeroPasajeros = numeroPasajeros;
    }

    public static Performable withNumber(String numeroCabinas, String numeroPasajeros){
        return instrumented(ChooseCabin.class, numeroCabinas, numeroPasajeros);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ChooseYourCabinPage.CBO_NUM_CABINS),
                SelectFromOptions.byVisibleText(numeroCabinas).from(ChooseYourCabinPage.CBO_NUM_CABINS),
                WaitUntil.the(ChooseYourCabinPage.CBO_NUM_ADULTS, isVisible()).forNoMoreThan(3).seconds(),
                SelectFromOptions.byVisibleText(numeroPasajeros).from(ChooseYourCabinPage.CBO_NUM_ADULTS)
        );
    }
}
