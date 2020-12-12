package Orange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static POMOrange.NewLogin.*;

public class OrangeNewUser {
    @Before
    public void setUp() throws Exception {
        abrirPagina();
        ingresarUser();

    }

    @After
    public void tearDown() throws Exception {
        cerrarNavegador();
    }

    @Test
    public void test() throws InterruptedException {
        validarCampo();

    }
}
