package Orange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static POMOrange.LoginAdmin.*;

public class OrangeNewLogin {
    @Before
    public void setUp() throws Exception {
        abrirPagina();
        newUser();
    }

    @After
    public void tearDown() throws Exception {
        cerrarNavegador();
    }

    @Test
    public void test() throws InterruptedException {
        validarCampo();
        validarRol();
        validarEmpUser();
        validarName();
        validarstatus();

    }

}
