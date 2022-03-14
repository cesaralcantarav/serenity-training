package com.automation.training.questions;

import com.automation.training.userinterfaces.ChooseYourCabinPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.Visibility;

public class ChooseYourCabinDisplayed {

    public static Question<Boolean> btnSearchTicketNow(){
        return actor -> Visibility.of(ChooseYourCabinPage.BTN_SEARCH_TICKET).viewedBy(actor).asBoolean();
    }

    public static Question<String> txtTotalSummary(){
        return actor -> TextContent.of(ChooseYourCabinPage.LBL_PRICE_SUMMARY).viewedBy(actor).asString();
    }

    public static String txtTotal(Actor actor){
        return ChooseYourCabinPage.LBL_PRICE.resolveFor(actor).getText();
    }
}
