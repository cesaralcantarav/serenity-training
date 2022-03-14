package com.automation.training.questions;

import com.automation.training.userinterfaces.ChooseYourCabinPage;
import com.automation.training.userinterfaces.PassangersDataPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class PassangersDataDisplayed {

    public static Question<Boolean> form(){
        return actor -> Visibility.of(PassangersDataPage.TXT_FIRST_NAME).viewedBy(actor).asBoolean();
    }
}
