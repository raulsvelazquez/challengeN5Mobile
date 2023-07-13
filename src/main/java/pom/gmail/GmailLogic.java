package pom.gmail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import steps.Hooks;

public class GmailLogic extends Hooks {

    GmailPage loginPage = new GmailPage();
    private static final Logger log = LogManager.getLogger(GmailLogic.class);

    public void abroAppGmail() {
        String step = "Ingreso a la aplicacion de Gmail";
        log.info(step);

        clickElement(loginPage.getBtnIngresar());
        clickElement(loginPage.getBtnIrGmail());
        clickElement(loginPage.getBtnPermitir());
        clickElement(loginPage.getBtnCerrar());
        clickElement(loginPage.getBtnCuenta());
        clickElement(loginPage.getBtnAgregar());
        clickElement(loginPage.getBtnGmail());
    }

    public void ingresoEmail(String email) {
        String step = "Ingreso el email " + email;
        log.info(step);

        write(loginPage.getInputEmail(), email);
        clickElement(loginPage.getBtnSiguiente());
        clickElement(loginPage.getBtnSiguienteDos());
    }

    public void ingresoClave(String clave) {
        String step = "Ingreso la clave " + clave;
        log.info(step);

        write(loginPage.getInputClave(), clave);
        clickElement(loginPage.getBtnSiguienteDos());
    }

    public void cuentaGmail() {
        String step = "Visualiza la cuenta de gmail";
        log.info(step);

        clickElement(loginPage.getBtnAcepto());
    }
}