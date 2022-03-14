package com.automation.training.questions;

import com.automation.training.userinterfaces.ConfirmationPaymentPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ConfirmationPaymentDisplayed {
    public static Question<Boolean> paymentMethod(){
        return actor -> Visibility.of(ConfirmationPaymentPage.LBL_PAYMENT_METHOD).viewedBy(actor).asBoolean();
    }
}
