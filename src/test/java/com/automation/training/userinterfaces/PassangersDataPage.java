package com.automation.training.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PassangersDataPage {
    public static Target TXT_FIRST_NAME = Target.the("Nombre").located(By.id("txt_nombre[suite][cab1][1]"));
    public static Target TXT_LAST_NAME = Target.the("Apellido").located(By.id("txt_apellido[suite][cab1][1]"));
    public static Target TXT_BIRTHDAY = Target.the("Fecha de nacimiento").located(By.id("txt_fecha_nacimiento[suite][cab1][1]"));
    public static Target LBL_DAY = Target.the("Fecha").locatedBy("//tbody/tr[1]/td[7]/a[1]");
    public static Target CBO_COUNTRY = Target.the("País").located(By.id("sel_nacion[suite][cab1][1]"));
    public static Target CBO_DOCUMENT_ID = Target.the("Tipo de documento").located(By.id("sel_tpdoc[suite][cab1][1]"));
    public static Target TXT_DOCUMENT_NUMBER = Target.the("Número de documento").located(By.id("txt_nroid[suite][cab1][1]"));
    public static Target CBO_SEX = Target.the("Sexo").located(By.id("sel_sexo[suite][cab1][1]"));
    public static Target TXT_TELEPHONE = Target.the("Teléfono").located(By.id("txt_telefono[suite][cab1][1]"));
    public static Target TXT_EMAIL = Target.the("Email").located(By.id("txt_mail[suite][cab1][1]"));
    public static Target TXT_CONFIRM_EMAIL = Target.the("Comfirmar email").located(By.id("txt_mail_conf[suite][cab1][1]"));
    public static Target BTN_CONTINUE = Target.the("Botón continuar").located(By.id("btnContinuarPas"));


}
