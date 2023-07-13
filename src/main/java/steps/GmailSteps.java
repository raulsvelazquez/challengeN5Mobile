package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.gmail.GmailLogic;

public class GmailSteps {

    GmailLogic loginLogic = new GmailLogic();

    @Given("Ingreso a la aplicacion de Gmail")
    public void ingresoALaAplicacionDeGmail() {
        loginLogic.abroAppGmail();
    }

    @When("Ingreso el email {string}")
    public void ingresoElEmail(String email) {
        loginLogic.ingresoEmail(email);
    }

    @And("Ingreso la clave {string}")
    public void ingresoLaClave(String clave) {
        loginLogic.ingresoClave(clave);
    }

    @Then("Visualiza la cuenta de gmail")
    public void visualizaLaCuentaDeGmail() {
        loginLogic.cuentaGmail();
    }
}