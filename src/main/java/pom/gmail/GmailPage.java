package pom.gmail;

import lombok.Getter;

@Getter
public class GmailPage {

    private final String btnIngresar = "//*/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView";
    private final String btnIrGmail = "//*/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
    private final String btnPermitir = "//*/android.widget.LinearLayout[2]/android.widget.Button[1]";
    private final String btnCerrar = "//android.widget.ImageButton[@content-desc='Cerrar']";
    private final String btnCuenta = "//*/android.widget.FrameLayout/android.widget.ImageView";
    private final String btnAgregar = "//*/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";
    private final String btnGmail = "//*/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout";
    private final String inputEmail = "//*/android.widget.FrameLayout/android.widget.EditText";
    private final String btnSiguiente = "//*/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]";
    private final String btnSiguienteDos = "//*/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button";
    private final String inputClave = "//*/android.view.View/android.view.View/android.widget.EditText";
    private final String btnAcepto = "//*/android.view.View[3]/android.view.View/android.widget.Button";
}
