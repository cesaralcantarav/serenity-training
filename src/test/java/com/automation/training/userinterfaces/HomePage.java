package com.automation.training.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static Target RADIO_ROUND_TRIP = Target.the("Tipo de viaje").located(By.id("roundtrip"));
    public static Target RADIO_ONE_WAY = Target.the("Tipo de viaje").located(By.id("oneway"));
    public static Target CBO_DESTINATION = Target.the("Destino").located(By.id("destinoSelect"));
    public static Target CBO_ROUTE = Target.the("Ruta").located(By.id("rutaSelect"));
    public static Target CBO_TRAIN = Target.the("Tren").located(By.id("cbTrenSelect"));
    public static Target BTN_NEXT = Target.the("Próximo mes").locatedBy("//span[contains(text(),'Next')]");
    public static Target LBL_MONTH = Target.the("Mes").locatedBy("//span[contains(text(),'October')]");
    public static Target LBL_DAY = Target.the("Día").locatedBy("//a[contains(text(),'{0}')]");
    public static Target TXT_DEPARTURE_DATE = Target.the("Fecha de salida").located(By.id("salida"));
    public static Target TXT_RETURN_DATE = Target.the("Fecha de regreso").located(By.id("regreso"));
    public static Target TXT_PASSANGER = Target.the("Pasajeros").located(By.id("countParentsChildren"));
    public static Target TXT_PASSANGER_DETAIL = Target.the("Adultos").located(By.id("adultsSelect"));
    public static Target BTN_SEARCH = Target.the("Botón buscar").located(By.id("btn_search"));
}
