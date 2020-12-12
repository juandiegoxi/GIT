package Orange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static POMOrange.SearchUser.*;

public class OrangeSearchUser {
    @Before
    public void setUp() throws Exception {
        abrirPagina();
        ingresarUser();
        buscaruser();
    }

    @After
    public void tearDown() throws Exception {
        cerrarNavegador();
    }

    @Test
    public void test() throws InterruptedException, IOException {

    }
}
