package POMOrange;

import Excel.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NewLogin {
    //Creacion del robot
    static WebDriver Aleja;
    //Declaracion variable leer y obtener campos
    static ReadExcelFile leerArchivo;
    //Ruta de enlace para encontrar el excel
    static String rutaArchivoDeExcel = "C:\\Users\\house\\Downloads\\Orange\\orage.xlsx";
    //Declaracion de variables para asignar el dato
    static String textoABuscar;

    //xpath
    static By user = By.id("txtUsername");
    static By password = By.id("txtPassword");
    static By login = By.id("btnLogin");
    static By search = By.xpath("//a[contains(text(),'>')]");

    //Metodo para abrir el navegador en la pagina Orange
    public static void abrirPagina() {
        //Abre el driver del navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\house\\Downloads\\Orange\\chromedriver.exe");
        //Declara el robor
        Aleja = new ChromeDriver();
        //Enlace que se copia al abrir el navegador
        Aleja.get("http://automationpractice.com/index.php");
        //Maximixa la pagina
        Aleja.manage().window().maximize();
    }

    //Metodo para ingresar el usuario
    public static void ingresarUser() throws InterruptedException, IOException {
        //Declara la varia que sea igual a archivo externo de excel
        leerArchivo = new ReadExcelFile();
        Aleja.findElement(user).click();
        textoABuscar = leerArchivo.getCellValue("NewLogin",rutaArchivoDeExcel , 1, 0);
        Aleja.findElement(user).sendKeys(textoABuscar);
        Aleja.findElement(password).click();
        textoABuscar = leerArchivo.getCellValue("NewLogin",rutaArchivoDeExcel , 1, 1);
        Aleja.findElement(password).sendKeys(textoABuscar);
        Aleja.findElement(login).sendKeys(Keys.ENTER);
    }
    //Metodo para cerrar el navegador
    public static void cerrarNavegador() {
        //Cierre del navegador
        Aleja.close();
    }

    public static void validarCampo() throws InterruptedException {
        //Obtiene los datos del campo y los compierte en texto
        String Validacion = Aleja.findElement(search).getText();
        assertThat(Validacion,is( "System Users"));
        //No se prueba, por que todos los usuarios que se creen quedan desactivados y no se activan
    }

}
