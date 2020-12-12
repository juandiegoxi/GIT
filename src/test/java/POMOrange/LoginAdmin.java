package POMOrange;


import Excel.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginAdmin {
    //Creacion del robot
    static WebDriver Aleja;
    //Declaracion variable leer y obtener campos
    static ReadExcelFile leerArchivo;
    //Ruta de enlace para encontrar el excel
    static String rutaArchivoDeExcel = "C:\\Users\\house\\Downloads\\Orange\\orage.xlsx";
    //Declaracion de variables para asignar el dato
    static String textoABuscar;
    //Declaracion de variables para asignar el dato
    static String rolUser;
    //Declaracion de variables para asignar el dato
    static String empUser1;
    //Declaracion de variables para asignar el dato
    static String statusUser;
    static String nameUser;




    //Xpath (Mapeo)
    static By user = By.id("txtUsername");
    static By password = By.id("txtPassword");
    static By login = By.id("btnLogin");
    static By btonAdmin = By.xpath("//b[contains(text(),'Admin')]");
    static By rol = By.id("systemUser_userType");
    static By empUser = By.id("systemUser_employeeName_empName");
    static By name = By.id("systemUser_userName");
    static By status = By.id("systemUser_status");
    static By password1 = By.id("systemUser_password");
    static By conPassword = By.id("systemUser_confirmPassword");
    static By btnSave = By.id("btnSave");
    static By btnAdd = By.id("btnAdd");



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
        textoABuscar = leerArchivo.getCellValue("Login",rutaArchivoDeExcel , 1, 0);
        Aleja.findElement(user).sendKeys(textoABuscar);
        Aleja.findElement(password).click();
        textoABuscar = leerArchivo.getCellValue("Login",rutaArchivoDeExcel , 1, 1);
        Aleja.findElement(password).sendKeys(textoABuscar);
        Aleja.findElement(login).sendKeys(Keys.ENTER);
        Aleja.findElement(btonAdmin).click();
    }

    //Metodo para ingresar el usuario
    public static void newUser() throws InterruptedException, IOException {
        Aleja.findElement(btnAdd).click();
        leerArchivo = new ReadExcelFile();
        Aleja.findElement(rol).click();
        textoABuscar = leerArchivo.getCellValue("NewUser",rutaArchivoDeExcel , 1, 0);
        rolUser=textoABuscar;
        Aleja.findElement(rol).sendKeys(textoABuscar);
        List<WebElement> listOfElements = Aleja.findElements (By.xpath ("//div[contains(@id, 'rand')]"));
        listOfElements.get(0).click();
        Aleja.findElement(empUser).click();
        textoABuscar = leerArchivo.getCellValue("NewUser",rutaArchivoDeExcel , 1, 1);
        empUser1=textoABuscar;
        Aleja.findElement(empUser).sendKeys(textoABuscar);
        Aleja.findElement(name).click();
        textoABuscar = leerArchivo.getCellValue("NewUser",rutaArchivoDeExcel , 1, 2);
        nameUser=textoABuscar;
        Aleja.findElement(name).sendKeys(textoABuscar);
        Aleja.findElement(status).click();
        textoABuscar = leerArchivo.getCellValue("NewUser",rutaArchivoDeExcel , 1, 3);
        statusUser=textoABuscar;
        Aleja.findElement(status).sendKeys(textoABuscar);
        List<WebElement> listOfElements1 = Aleja.findElements (By.xpath ("//div[contains(@id, 'rand')]"));
        listOfElements1.get(0).click();
        Aleja.findElement(password1).click();
        textoABuscar = leerArchivo.getCellValue("NewUser",rutaArchivoDeExcel , 1, 4);
        Aleja.findElement(password1).sendKeys(textoABuscar);
        Aleja.findElement(conPassword).click();
        textoABuscar = leerArchivo.getCellValue("NewUser",rutaArchivoDeExcel , 1, 4);
        Aleja.findElement(conPassword).sendKeys(textoABuscar);

    }

    public static void validarCampo() throws InterruptedException {
        //Obtiene los datos del campo y los compierte en texto
        String Validacion = Aleja.findElement(btnAdd).getTagName();
        assertThat(Validacion,is( btnAdd));
    }

    public static void validarRol() throws InterruptedException {
        //Obtiene los datos del campo y los compierte en texto
        String Validacion = Aleja.findElement(rol).getText();
        assertThat(Validacion,is( rolUser));
    }

    public static void validarEmpUser() throws InterruptedException {
        //Obtiene los datos del campo y los compierte en texto
        String Validacion = Aleja.findElement(empUser).getText();
        assertThat(Validacion,is( empUser1));
    }
    public static void validarName() throws InterruptedException {
        //Obtiene los datos del campo y los compierte en texto
        String Validacion = Aleja.findElement(name).getText();
        assertThat(Validacion,is( nameUser));
    }
    public static void validarstatus() throws InterruptedException {
        //Obtiene los datos del campo y los compierte en texto
        String Validacion = Aleja.findElement(status).getText();
        System.out.println(Validacion);
        assertThat(Validacion,is( statusUser));
        Aleja.findElement(btnSave).click();
    }

    //Metodo para cerrar el navegador
    public static void cerrarNavegador() {
        //Cierre del navegador
        Aleja.close();
    }
}
