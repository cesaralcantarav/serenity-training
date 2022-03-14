package com.automation.training.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPaymentPage {
    public static Target LBL_PAYMENT_METHOD = Target.the("Texto método de pago").locatedBy("//div[@class='title-pasajero']");
}
