package com.automation.training.tasks;

import com.automation.training.userinterfaces.PassangersDataPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterPassangerData implements Task {
    private final String nombre;
    private final String apellido;
    private final String fechaNacimiento;
    private final String nacionalidad;
    private final String tipoDocumento;
    private final String numeroDocumento;
    private final String sexo;
    private final String telefono;
    private final String email;

    public EnterPassangerData(String nombre, String apellido, String fechaNacimiento, String nacionalidad, String tipoDocumento, String numeroDocumento, String sexo, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
    }

    public static Performable withData(String nombre, String apellido, String fechaNacimiento, String nacionalidad, String tipoDocumento, String numeroDocumento, String sexo, String telefono, String email) {
        return instrumented(EnterPassangerData.class, nombre, apellido, fechaNacimiento, nacionalidad, tipoDocumento, numeroDocumento, sexo, telefono, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(PassangersDataPage.TXT_FIRST_NAME),
                Enter.theValue(apellido).into(PassangersDataPage.TXT_LAST_NAME),
                Click.on(PassangersDataPage.TXT_BIRTHDAY),
                Click.on(PassangersDataPage.LBL_DAY),
                SelectFromOptions.byVisibleText(nacionalidad).from(PassangersDataPage.CBO_COUNTRY),
                SelectFromOptions.byVisibleText(tipoDocumento).from(PassangersDataPage.CBO_DOCUMENT_ID),
                Enter.theValue(numeroDocumento).into(PassangersDataPage.TXT_DOCUMENT_NUMBER),
                SelectFromOptions.byVisibleText(sexo).from(PassangersDataPage.CBO_SEX),
                Clear.field(PassangersDataPage.TXT_TELEPHONE),
                Enter.theValue(telefono).into(PassangersDataPage.TXT_TELEPHONE),
                Enter.theValue(email).into(PassangersDataPage.TXT_EMAIL),
                Enter.theValue(email).into(PassangersDataPage.TXT_CONFIRM_EMAIL),
                Click.on(PassangersDataPage.BTN_CONTINUE)

        );
    }
}
