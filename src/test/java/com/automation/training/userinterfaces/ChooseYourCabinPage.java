package com.automation.training.userinterfaces;

import net.serenitybdd.screenplay.questions.targets.TargetText;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ChooseYourCabinPage {
    public static Target BTN_SEARCH_TICKET = Target.the("Botón buscar ticket ahora").located(By.id("btn_search_bae"));
    public static Target CBO_NUM_CABINS = Target.the("Número de cabinas").locatedBy("//*[@id='frm_viajes_bae']/div[3]/div[2]/div[2]/div[3]/div/div[1]/select");
    public static Target CBO_NUM_ADULTS = Target.the("Número de adultos").locatedBy("//*[@id='suite']/div/div[2]/div[1]/select");
    public static Target BTN_PURCHASE_SUMMARY = Target.the("Resumen de compra").locatedBy("//a[normalize-space()='purchase summary']");
    public static Target LBL_PRICE_SUMMARY = Target.the("Precio resumen").located(By.id("priceUSDrc"));
    public static Target LBL_PRICE = Target.the("Precio").located(By.id("priceUSD"));
    public static Target BTN_CONTINUE = Target.the("Botón continuar").located(By.id("continuar_bae"));
}
